package com.httm.service;

import java.util.List;

import com.httm.dto.CoorDTO;

public interface ICoorService {
	List<CoorDTO> findAll(Long id);
}
