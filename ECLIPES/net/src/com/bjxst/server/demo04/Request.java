package com.bjxst.server.demo04;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * ��װrequest
 * @author llf
 *
 */
public class Request {
	//����ʽ
	private String method;
	//������Դ
	private String url;
	//�������
	private Map<String,List<String>> parameterMapValues;
	//�ڲ�
	public static final String CRLF="\r\n";
	private InputStream is;
	private String requestInfo;

	public Request(){
		method ="";
		url="";
		parameterMapValues = new HashMap<String,List<String>>();
		requestInfo ="";
	}
	public Request(InputStream is){
		this();
		this.is=is;
		try {
			byte[] data=new byte[20480];
			int len = is.read(data);
			requestInfo=new String(data,0,len);
		} catch (IOException e) {
			return ;
		}
		//����������Ϣ
		parseRequestInfo();
	}
	/*
	 * ����������Ϣ*
	 */
	private void parseRequestInfo() {
		if(null==requestInfo || (requestInfo.trim()).equals("")){
			return ;
		}
		/**
		 * ==========================================
		 * �� ��Ϣ�����зֽ��������ʽ������·�������������get���ܴ��ڣ�
		 * GET /index?uname=123&pwd=123 HTTP/1.1
		 * �����post��ʽ�������������������������
		 * 
		 * ==========================================
		 * 
		 */
		String paramString ="";//�����������
		//1��ȡ����ʽ
		String firstLine =requestInfo.substring(0,requestInfo.indexOf(CRLF));
		int idx=requestInfo.indexOf("/");
		this.method=firstLine.substring(0,idx).trim();
		String urlStr=firstLine.substring(idx,firstLine.indexOf("HTTP/")).trim();
		
		if(this.method.equalsIgnoreCase("post")){
			this.url=urlStr;
			paramString=requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
		}else if(this.method.equalsIgnoreCase("get")){
			if(url.contains("?")){//�Ƿ���ڲ���
				String[] urlArray=urlStr.split("\\?");
				this.url=urlArray[0];
				paramString=urlArray[1];//�����������
			}else{
				this.url=urlStr;
				
			}
			
		}
		//���������װ��Map��
		if(paramString.equals("")){
			return ;
			
		}
		parseParams(paramString);
	}
	//���������װ��Map��
	private void parseParams(String paramString) {
		//�ָ� ���ַ���ת������
		StringTokenizer token=new StringTokenizer(paramString,"&");
		while(token.hasMoreTokens()){
			String KeyValue =token.nextToken();
			String[] KeyValues = KeyValue.split("=");
			if(KeyValues.length==1){
				KeyValues= Arrays.copyOf(KeyValues, 2);
				KeyValues[1]=null;	
			}
			String key = KeyValues[0].trim();
			String value = null==KeyValues[1]?null:decode(KeyValues[1].trim(),"gbk");
			//ת����Map�ּ�
			if(!parameterMapValues.containsKey(key)){
				parameterMapValues.put(key,new ArrayList<String>());
			}
			
			List<String> values = parameterMapValues.get(key);
			values.add(value);
		}
	}
	/**
	 * �������
	 * @param values
	 * @param code
	 * @return
	 */
	private String decode(String values,String code){
		try {
			return java.net.URLDecoder.decode(values, code);
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}
	
	/**
	 * ����ҳ���name��ȡ��Ӧ�Ķ��ֵ
	 * @param args
	 */
	public String getParameter(String name){
		String[] values=getParameterValues(name);
		if(null==values){
			return null;				
		}
		return values[0];
	}
	
	public String[] getParameterValues(String name){
		List<String> values=null;
		if((values=parameterMapValues.get(name))==null){
			return null;			
		}else{
			return values.toArray(new String[0]);
		}
	}
	public String getUrl() {
		return url;
	}
}