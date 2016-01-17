package com.bjxst.server.demo;

import java.util.ArrayList;
import java.util.List;

/**
 <servlet-mapping>
		<servlet-name>login</servlet-name>
		<url-pattern>/login</url-pattern>
	</servlet-mapping>
	<mapping>
		<servlet-name>login</servlet-name>
		<url-pattern>/log</url-pattern>
	</servlet-mapping>
	<servlet>
		<servlet-name>reg</servlet-name>
		<servlet-class>com.bjxst.server.demo04.RegisterServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>reg</servlet-name>
		<url-pattern>/reg</url-pattern>
	</servlet-mapping> 
 * @author llf
 *
 */
public class Mapping {
	private String name;
	private List<String> urlPattern;
	
	public Mapping() {
		urlPattern = new ArrayList<String>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getUrlPattern() {
		return urlPattern;
	}
	public void setUrlPattern(List<String> urlPattern) {
		this.urlPattern = urlPattern;
	}
	
}
