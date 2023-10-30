package com.httm.converter;



import org.springframework.stereotype.Component;

import com.httm.dto.BT2DTO;
import com.httm.entity.SimpleBT2Entity;

@Component
public class BT2Converter {
	public SimpleBT2Entity toEntity(BT2DTO dto) {
		SimpleBT2Entity entity = new SimpleBT2Entity();
		entity.setImage(dto.getImage());	
		return entity;
	}
	public static BT2DTO  toDTO(SimpleBT2Entity entity) {
		BT2DTO dto = new BT2DTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setImage(entity.getImage());
		dto.setDate(entity.getDate());
		return dto;
	}
	public SimpleBT2Entity toEntity(BT2DTO dto , SimpleBT2Entity entity) {
		entity.setImage(dto.getImage());
		return entity;
	}
}
