package com.httm.api.output;

import java.util.*;
import java.util.ArrayList;

import com.httm.dto.BT1DTO;

public class BT1Output {
	
	private int page;
	private int totalPage;
	private List<BT1DTO> listSimple = new ArrayList<>();
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public List<BT1DTO> getListSimple() {
		return listSimple;
	}
	
	public void setListSimple(List<BT1DTO> listSimple) {
		this.listSimple = listSimple;
	}
	
}
