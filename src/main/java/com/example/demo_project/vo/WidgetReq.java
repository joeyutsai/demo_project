package com.example.demo_project.vo;

public class WidgetReq {
	private Integer id;
	private String name;

	public WidgetReq() {

	}
	
	public WidgetReq(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
