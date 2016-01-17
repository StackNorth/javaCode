package com.bjxst.server.demo04;

import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.bjxst.xml.PersonHandler;

public class WebApp {
	private static ServletContext contxt;
	static{
		try{
			//1、获取解析工厂
			SAXParserFactory factory= SAXParserFactory.newInstance();
			//2、从解析工厂获取解析器
			SAXParser parser=factory.newSAXParser();
			//3、加载文档Document注册处理器
			//4、编写处理器
			WebHandler web = new WebHandler();
			parser.parse(Thread.currentThread().getContextClassLoader()
			.getResourceAsStream("com/bjxst/server/demo04/Web.xml"),web);
			//	将list转成map
			contxt = new ServletContext();
			Map<String,String> servlet=contxt.getServlet();
			//存servlet-name servlet-clz
			for(Entity entity:web.getEntityList()){
					 servlet.put(entity.getName(),entity.getClz());
			}
			//存URL-pattern servlet-name
			Map<String,String> mapping=contxt.getMapping();
			for(Mapping mapp:web.getMappingList()){
				List<String> urls = mapp.getUrlPattern();
				for(String url:urls){	
					mapping.put(url,mapp.getName());
					
				}
			}
		}catch(Exception e){
			System.out.println("error");
		}
		
		
	}
	public static Servlet getServlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		if((null==url)||(url.trim()).equals("")){
			return null;
		}
		String name=contxt.getServlet().get(contxt.getMapping().get(url));
		if(null==name){
			return null;
		}
		//根据字符串（完整路径）创建对象
		return (Servlet)Class.forName(name).newInstance();//确保空构造存在
		//return contxt.getServlet().get(contxt.getMapping().get(url));
	}
}
