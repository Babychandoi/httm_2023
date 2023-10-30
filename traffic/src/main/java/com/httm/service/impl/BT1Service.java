package com.httm.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import com.httm.converter.BT1Converter;
import com.httm.dto.BT1DTO;
import com.httm.entity.SimpleBT1Entity;
import com.httm.repository.BT1Reqository;
import com.httm.service.IBT1Service;
@Service
public class BT1Service implements IBT1Service {
	@Autowired
	private BT1Reqository bt1Repository;
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public List<BT1DTO> findAll(Pageable pageable) {
		List<BT1DTO> results = new ArrayList<>();
		List<SimpleBT1Entity> entities = bt1Repository.findAll(pageable).getContent();
		for(SimpleBT1Entity item : entities) {
			BT1DTO bt1dto = BT1Converter.toDTO(item);
			results.add(bt1dto);
		}
		return results;
	}

	@Override
	public int totalItem() {
		return (int) bt1Repository.count();
	}

	@Override
	public void delete(Long id) {
	    SimpleBT1Entity entity = bt1Repository.findOne(id);
	    String deleteCoordinatesQuery = "DELETE FROM Coordinates WHERE id_Image = ?";
        jdbcTemplate.update(deleteCoordinatesQuery, id);
	        bt1Repository.delete(entity);
	}

}
