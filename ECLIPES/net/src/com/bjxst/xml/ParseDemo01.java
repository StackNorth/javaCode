package com.bjxst.xml;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParseDemo01 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//1����ȡ��������
		SAXParserFactory factory= SAXParserFactory.newInstance();
		//2���ӽ���������ȡ������
		SAXParser parser=factory.newSAXParser();
		//3�������ĵ�Documentע�ᴦ����
		//4����д������
		PersonHandler handler = new PersonHandler();
		parser.parse(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("com/bjxst/xml/person.xml"),handler);
		
		List<person> persons= handler.getPersons();
		for(person temp:persons){
			System.out.println(temp.getName()+"--->"+temp.getAge());
			
		}
	}

}
