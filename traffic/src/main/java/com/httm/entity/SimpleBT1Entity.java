package com.httm.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "SimpleBT1")
@EntityListeners(AuditingEntityListener.class)
public class SimpleBT1Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "imagee")
	private String image;
	
	@Column(name = "Date")
	@CreatedDate
	private Date date;

	public String getImagee() {
		return image;
	}

	public void setImagee(String image) {
		this.image = image;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}
	
	
}
