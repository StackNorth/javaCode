package com.bjxst.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 * �洢����
 * @author llf
 *
 */
public class PersonHandler extends DefaultHandler{
	private String tag;
	private List<person> persons;
	private person person;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("�����ĵ���ʼ");
		persons =new ArrayList<person>();
	}
	
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("��ʼһ��Ԫ��"+qName);
		if(null!=qName){
			tag=qName;
		}
		if(null!=qName && qName.equals("person")){
			person =new person();
		}
	
	}
	
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String str= new String(ch,start,length);
		if(tag!=null && tag.equals("name")){
			person.setName(str);
			
		}else if(null!=tag && tag.equals("age")){
			Integer age= Integer.valueOf(str);
			person.setAge(age);
			
		}
		//System.out.println(new String(ch,start,length));
	}
	
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//System.out.println("����һ��Ԫ��"+qName);
		
		if(qName.equals("person")){
			this.persons.add(person);
		}
		tag=null;
	}
	
	public void endDocument() throws SAXException {
		System.out.println("�����ĵ�����");
	}

	public List<person> getPersons() {
		return persons;
	}

	public void setPersons(List<person> persons) {
		this.persons = persons;
	}



	

	
	
}
