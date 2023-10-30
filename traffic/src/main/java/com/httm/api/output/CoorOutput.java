package com.httm.api.output;

import java.util.ArrayList;
import java.util.List;

import com.httm.dto.CoorDTO;

public class CoorOutput {
	private List<CoorDTO> listCoor = new ArrayList<>();

	public List<CoorDTO> getListCoor() {
		return listCoor;
	}

	public void setListCoor(List<CoorDTO> listCoor) {
		this.listCoor = listCoor;
	}
	
}
