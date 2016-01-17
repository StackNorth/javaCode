package com.bjxst.server.demo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

import com.bjxst.closeutil.CloseUtil;

/**
 * 封装响应信息
 * @author llf
 *
 */
public class Response {
	//两个常量
	public static final String CRLF="\r\n";
	public String BLANK=" ";
	//头信息
	private StringBuilder headInfo;
	//长度
	private int len=0;
	//正文
	private StringBuilder content;
	private BufferedWriter bw;
	public Response() {
		//头信息
		headInfo= new StringBuilder();
		//正文信息
		content = new StringBuilder();
		len=0;
	}
	
	public Response(Socket client) {
		this();
		try {
			bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			headInfo=null;
		}
	}
	
	public Response(OutputStream os) {
		this();
		bw=new BufferedWriter(new OutputStreamWriter(os));
	}
	
	/**
	 * 构建正文
	 * @param info
	 */
	public Response print(String info){
		content.append(info);
		len+=info.getBytes().length;
		return this;
	}
	
	public Response println(String info){
		content.append(info).append(CRLF);
		len+=(info+CRLF).getBytes().length;
		return this;
	}
	
	
	
	private void createHeadInfo(int code){
		//1http洗衣版本 ，状态代码，描述
		headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
		switch(code){
			case 200:
				 headInfo.append("OK");
				 break;
			case 404:
				 headInfo.append("ONT FOUND");
				 break;
			case 500:
				 headInfo.append("Server error");
				 break;	 
		}
		//响应头（response head）
		headInfo.append("Server:bjxst Server/0.0.1").append(CRLF);
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Content-type:text/html;charset=GBK;").append(CRLF);
		//正文长度，字节长度
		headInfo.append("Content-Length:").append(len).append(CRLF);
		//正文之前
		headInfo.append(CRLF);
		
	
	}
	/**
	 * 推送出去
	 * @param code
	 * @throws IOException 
	 */
	void pushToClient(int code) throws IOException{
		if(null==headInfo){
			
			code=500;
		}
		createHeadInfo(code);
		//头信息+分隔符
		bw.append(headInfo.toString());
		//正文
		bw.append(content.toString());
		bw.flush();
		
	}
	public void close(){
		CloseUtil.Close(bw);
	}
}
