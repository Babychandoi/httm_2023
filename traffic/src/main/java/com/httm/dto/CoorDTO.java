package com.httm.dto;

public class CoorDTO extends AbstactDTO{
	private double x_min;
	private double y_min;
	private double x_max;
	private double y_max;
	public double getX_min() {
		return x_min;
	}
	public void setX_min(double x_min) {
		this.x_min = x_min;
	}
	public double getY_min() {
		return y_min;
	}
	public void setY_min(double y_min) {
		this.y_min = y_min;
	}
	public double getX_max() {
		return x_max;
	}
	public void setX_max(double x_max) {
		this.x_max = x_max;
	}
	public double getY_max() {
		return y_max;
	}
	public void setY_max(double y_max) {
		this.y_max = y_max;
	}
	
}
