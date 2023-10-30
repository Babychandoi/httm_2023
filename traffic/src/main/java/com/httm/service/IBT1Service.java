package com.httm.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.httm.dto.BT1DTO;
@Service
public interface IBT1Service {
	List<BT1DTO> findAll(Pageable pageable);
	int totalItem();
	void delete(Long id);
}
