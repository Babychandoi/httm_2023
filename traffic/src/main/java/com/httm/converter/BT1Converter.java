package com.httm.converter;

import org.springframework.stereotype.Component;

import com.httm.dto.BT1DTO;
import com.httm.entity.SimpleBT1Entity;
@Component
public class BT1Converter {
	public SimpleBT1Entity toEntity(BT1DTO dto) {
		SimpleBT1Entity entity = new SimpleBT1Entity();
		entity.setImagee(dto.getImage());	
		return entity;
	}
	public static BT1DTO  toDTO(SimpleBT1Entity entity) {
		BT1DTO dto = new BT1DTO();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setImage(entity.getImagee());
		dto.setDate(entity.getDate());
		return dto;
	}
	public SimpleBT1Entity toEntity(BT1DTO dto , SimpleBT1Entity entity) {
		entity.setImagee(dto.getImage());
		return entity;
	}
}