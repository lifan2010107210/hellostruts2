package com.vo;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = -8929590141723245411L;
	
	private String stuId;
	private String stuName;
	private String clsName;
	
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getClsName() {
		return clsName;
	}
	public void setClsName(String clsName) {
		this.clsName = clsName;
	}
	
	

}
