package com.httm.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.httm.converter.BT2Converter;
import com.httm.dto.BT2DTO;
import com.httm.entity.LabelsEntity;
import com.httm.entity.SimpleBT2Entity;
import com.httm.repository.BT2Repository;
import com.httm.repository.LabelsRepository;
import com.httm.service.IBT2Service;
import org.springframework.jdbc.core.JdbcTemplate;
@Service
public class BT2Service implements IBT2Service {
	
	@Autowired
	private BT2Repository bt2Repository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BT2Converter bt2Converter;
	
	@Autowired
	LabelsRepository labelsRepository;
	
	@Override
	public BT2DTO save(BT2DTO bt2dto) {
		SimpleBT2Entity bt2Entity = new SimpleBT2Entity();
		if (bt2dto.getId() != null) {
			SimpleBT2Entity oldSimple = bt2Repository.findOne(bt2dto.getId());
			bt2Entity = bt2Converter.toEntity(bt2dto, oldSimple);
		} else {
			bt2Entity = bt2Converter.toEntity(bt2dto);
		}
		LabelsEntity labelsEntity = labelsRepository.findOneByName(bt2dto.getName());
		bt2Entity.setLabel(labelsEntity);

		bt2Entity = bt2Repository.save(bt2Entity);
		return BT2Converter.toDTO(bt2Entity);
	}

	@Override
	public void delete(Long id) {
		bt2Repository.delete(id);
	}

	@Override
	public int totalItem() {
		
		return (int) bt2Repository.count();
	}

	@Override
	public List<BT2DTO> findAll(Pageable pageable) {
		List<BT2DTO> results = new ArrayList<>();
		List<SimpleBT2Entity> entities =  bt2Repository.findAll(pageable).getContent();
		for(SimpleBT2Entity item : entities) {
			BT2DTO bt2dto = BT2Converter.toDTO(item);
			LabelsEntity a = item.getLabel();
			bt2dto.setName(a.getName());
			results.add(bt2dto);
		}
		return results;
	}

	@Override
	public List<BT2DTO> findall(String name) {
        String selectSimple2= "SELECT s2.id, s2.datee, s2.imagee FROM simplebt2 s2 JOIN labels l ON s2.id_label = l.id WHERE l.name = ?";
        List<BT2DTO> result = jdbcTemplate.query(selectSimple2, new Object[]{name}, new RowMapper<BT2DTO>() {
            @Override
        	public BT2DTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            	BT2DTO bt2DTO = new BT2DTO();
            	 bt2DTO.setId(rs.getLong("id"));
                bt2DTO.setDate(rs.getDate("datee"));
                bt2DTO.setImage(rs.getString("imagee"));
                bt2DTO.setName(name);

                return bt2DTO;
            }
        });
        return result;
	}

}
