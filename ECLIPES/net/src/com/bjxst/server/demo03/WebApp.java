package com.bjxst.server.demo03;

import java.util.Map;

public class WebApp {
	private static ServletContext contxt;
	static{
		contxt = new ServletContext();
		Map<String,String> mapping=contxt.getMapping();
		mapping.put("/login","login");
		mapping.put("/log","login");
		mapping.put("/reg","register");
		
		Map<String,String> servlet=contxt.getServlet();
		servlet.put("login","com.bjxst.server.demo03.LoginServlet");
		servlet.put("register","com.bjxst.server.demo03.RegisterServlet");
	}
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		if((null==url)||(url.trim()).equals("")){
			return null;
		}
		String name=contxt.getServlet().get(contxt.getMapping().get(url));
		//根据字符串（完整路径）创建对象
		return (Servlet)Class.forName(name).newInstance();//确保空构造存在
		//return contxt.getServlet().get(contxt.getMapping().get(url));
	}
}
