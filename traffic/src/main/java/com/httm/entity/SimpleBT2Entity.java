package com.httm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "SimpleBT2")
@EntityListeners(AuditingEntityListener.class)
public class SimpleBT2Entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
    @JoinColumn(name = "idLabel")
	private LabelsEntity Label;

	@Column(name = "imagee")
	private String image;

	@Column(name="datee")
	@CreatedDate
	private Date date;
	public LabelsEntity getLabel() {
		return Label;
	}

	public void setLabel(LabelsEntity label) {
		Label = label;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
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
