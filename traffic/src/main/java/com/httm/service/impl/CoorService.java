package com.httm.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.httm.dto.CoorDTO;
import com.httm.entity.CoordinatesEntity;
import com.httm.service.ICoorService;
@Service
public class CoorService implements ICoorService{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<CoorDTO> findAll( Long id) {
		List<CoorDTO> result = new ArrayList<>();
		CoorDTO coorDTO = new CoorDTO();
        String selectCoordinatesQuery = "SELECT * FROM Coordinates WHERE id_image = ?";
        List<CoordinatesEntity> coordinatesList = jdbcTemplate.query(selectCoordinatesQuery, new Object[]{id}, new RowMapper<CoordinatesEntity>() {
            @Override
        	public CoordinatesEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            	CoordinatesEntity coordinates = new CoordinatesEntity();
                coordinates.setId(rs.getLong("id"));
                coordinates.setCreateDate(rs.getDate("create_date"));
                coordinates.setXmin(rs.getDouble("xmin"));
                coordinates.setYmin(rs.getDouble("ymin"));
                coordinates.setXmax(rs.getDouble("xmax"));
                coordinates.setYmax(rs.getDouble("ymax"));

                return coordinates;
            }
        });
        for(CoordinatesEntity entity : coordinatesList) {
        	coorDTO.setId(entity.getId());
        	coorDTO.setDate(entity.getCreateDate());
        	coorDTO.setX_min(entity.getXmin());
        	coorDTO.setY_min(entity.getYmin());
        	coorDTO.setX_max(entity.getXmax());
        	coorDTO.setY_max(entity.getYmax());
        	result.add(coorDTO);
        	
        }
        return result;
    }

}
