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
			//1����ȡ��������
			SAXParserFactory factory= SAXParserFactory.newInstance();
			//2���ӽ���������ȡ������
			SAXParser parser=factory.newSAXParser();
			//3�������ĵ�Documentע�ᴦ����
			//4����д������
			WebHandler web = new WebHandler();
			parser.parse(Thread.currentThread().getContextClassLoader()
			.getResourceAsStream("com/bjxst/server/demo04/Web.xml"),web);
			//	��listת��map
			contxt = new ServletContext();
			Map<String,String> servlet=contxt.getServlet();
			//��servlet-name servlet-clz
			for(Entity entity:web.getEntityList()){
					 servlet.put(entity.getName(),entity.getClz());
			}
			//��URL-pattern servlet-name
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
		//�����ַ���������·������������
		return (Servlet)Class.forName(name).newInstance();//ȷ���չ������
		//return contxt.getServlet().get(contxt.getMapping().get(url));
	}
}
