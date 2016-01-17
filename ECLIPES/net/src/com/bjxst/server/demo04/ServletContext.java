package com.bjxst.server.demo04;

import java.util.HashMap;
import java.util.Map;

public class ServletContext {
	//为每一个servlet取个别名
	//login --》LoginServlet
	private Map<String,String> servlet;
	
	private Map<String,String> mapping;
	
	public ServletContext() {
		servlet = new HashMap<String,String>();
		mapping = new HashMap<String,String>();
	}
	public Map<String, String> getServlet() {
		return servlet;
	}
	public void setServlet(Map<String, String> servlet) {
		this.servlet = servlet;
	}
	public Map<String, String> getMapping() {
		return mapping;
	}
	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	
}
