package com.bjxst.server.demo02;

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
 * 封装request
 * @author llf
 *
 */
public class Request {
	//请求方式
	private String method;
	//请求资源
	private String url;
	//请求参数
	private Map<String,List<String>> parameterMapValues;
	//内部
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
		//分析请求信息
		parseRequestInfo();
	}
	/*
	 * 分析请求信息*
	 */
	private void parseRequestInfo() {
		if(null==requestInfo || (requestInfo.trim()).equals("")){
			return ;
		}
		/**
		 * ==========================================
		 * 从 信息的首行分解出：请求方式，请求路径，请求参数（get可能存在）
		 * GET /index?uname=123&pwd=123 HTTP/1.1
		 * 如果是post方式，请求参数可能在最后的正文中
		 * 
		 * ==========================================
		 * 
		 */
		String paramString ="";//接收请求参数
		//1获取请求方式
		String firstLine =requestInfo.substring(0,requestInfo.indexOf(CRLF));
		int idx=requestInfo.indexOf("/");
		this.method=firstLine.substring(0,idx).trim();
		String urlStr=firstLine.substring(idx,firstLine.indexOf("HTTP/")).trim();
		
		if(this.method.equalsIgnoreCase("post")){
			this.url=urlStr;
			paramString=requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
		}else if(this.method.equalsIgnoreCase("get")){
			if(url.contains("?")){//是否存在参数
				String[] urlArray=urlStr.split("\\?");
				this.url=urlArray[0];
				paramString=urlArray[1];//接收请求参数
			}else{
				this.url=urlStr;
				
			}
			
		}
		//请求参数封装到Map中
		if(paramString.equals("")){
			return ;
			
		}
		parseParams(paramString);
	}
	//请求参数封装到Map中
	private void parseParams(String paramString) {
		//分割 将字符串转成数组
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
			//转换成Map分拣
			if(!parameterMapValues.containsKey(key)){
				parameterMapValues.put(key,new ArrayList<String>());
			}
			
			List<String> values = parameterMapValues.get(key);
			values.add(value);
		}
	}
	/**
	 * 解决中文
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
	 * 根据页面的name获取对应的多个值
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
