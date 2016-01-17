package com.bjxst.xml;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParseDemo01 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//1、获取解析工厂
		SAXParserFactory factory= SAXParserFactory.newInstance();
		//2、从解析工厂获取解析器
		SAXParser parser=factory.newSAXParser();
		//3、加载文档Document注册处理器
		//4、编写处理器
		PersonHandler handler = new PersonHandler();
		parser.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("com/bjxst/xml/person.xml"),handler);
		
		List<person> persons= handler.getPersons();
		for(person temp:persons){
			System.out.println(temp.getName()+"--->"+temp.getAge());
			
		}
	}

}
