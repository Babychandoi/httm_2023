package com.httm.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.httm.dto.BT2DTO;
@Service
public interface IBT2Service  { 
	BT2DTO save(BT2DTO bt2DTO);
	void delete(Long id);
	List<BT2DTO> findAll(Pageable pageable);
	int totalItem();
	List<BT2DTO> findall(String name);
}
