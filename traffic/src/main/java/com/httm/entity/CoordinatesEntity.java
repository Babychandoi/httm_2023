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
@Table(name = "Coordinates")
@EntityListeners(AuditingEntityListener.class)
public class CoordinatesEntity {
	
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
    @JoinColumn(name = "idImage")
	private SimpleBT1Entity simpleBT1Entity; 
	
	@Column
	private Double xmin;
	
	@Column
	private Double ymin;
	
	@Column
	private Double xmax;
	
	@Column
	private Double ymax;
	
	@Column(name="createDate")
	@CreatedDate
	private Date createDate;
	public SimpleBT1Entity getSimpleBT1Entity() {
		return simpleBT1Entity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getXmin() {
		return xmin;
	}

	public void setXmin(Double xmin) {
		this.xmin = xmin;
	}

	public void setSimpleBT1Entity(SimpleBT1Entity simpleBT1Entity) {
		this.simpleBT1Entity = simpleBT1Entity;
	}

	public Double getYmin() {
		return ymin;
	}

	public void setYmin(Double ymin) {
		this.ymin = ymin;
	}

	public Double getXmax() {
		return xmax;
	}

	public void setXmax(Double xmax) {
		this.xmax = xmax;
	}

	public Double getYmax() {
		return ymax;
	}

	public void setYmax(Double ymax) {
		this.ymax = ymax;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	

	
}
