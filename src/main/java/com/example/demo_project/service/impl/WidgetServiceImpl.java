package com.example.demo_project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Widget;
import com.example.demo_project.repository.WidgetDao;
import com.example.demo_project.service.ifs.WidgetService;

@Service
public class WidgetServiceImpl implements WidgetService {
	@Autowired
	private WidgetDao widgetDao;
	
	@Override
	public Widget save() {
		Widget widget = new Widget();
		widget.setName("AAA");
		return widgetDao.save(widget);
	}

	@Override
	public Widget saveByName(String name) {
		Widget widget = new Widget();
		widget.setName(name);
		return widgetDao.save(widget);
	}

}
