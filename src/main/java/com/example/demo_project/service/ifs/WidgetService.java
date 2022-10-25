package com.example.demo_project.service.ifs;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Widget;

public interface WidgetService {
	public Widget save();
	public Widget saveByName(String name);
}
