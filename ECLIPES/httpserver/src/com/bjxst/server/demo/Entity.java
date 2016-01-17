package com.bjxst.server.demo;
/**
<servlet>
		<servlet-name>login</servlet-name>
		<servlet-class>com.bjxst.server.demo04.LoginServlet</servlet-class>
	</servlet>
 * @author llf
 *
 */
public class Entity {
	private String name;
	private String clz;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClz() {
		return clz;
	}
	public void setClz(String clz) {
		this.clz = clz;
	}
	
}
