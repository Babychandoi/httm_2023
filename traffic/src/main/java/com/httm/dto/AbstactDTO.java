package com.httm.dto;

import java.util.Date;

public class AbstactDTO {
	private Long id;
	private Date date;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
