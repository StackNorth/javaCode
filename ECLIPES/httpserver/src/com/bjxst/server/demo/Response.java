package com.bjxst.server.demo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

import com.bjxst.closeutil.CloseUtil;

/**
 * ��װ��Ӧ��Ϣ
 * @author llf
 *
 */
public class Response {
	//��������
	public static final String CRLF="\r\n";
	public String BLANK=" ";
	//ͷ��Ϣ
	private StringBuilder headInfo;
	//����
	private int len=0;
	//����
	private StringBuilder content;
	private BufferedWriter bw;
	public Response() {
		//ͷ��Ϣ
		headInfo= new StringBuilder();
		//������Ϣ
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
	 * ��������
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
		//1httpϴ�°汾 ��״̬���룬����
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
		//��Ӧͷ��response head��
		headInfo.append("Server:bjxst Server/0.0.1").append(CRLF);
		headInfo.append("Date:").append(new Date()).append(CRLF);
		headInfo.append("Content-type:text/html;charset=GBK;").append(CRLF);
		//���ĳ��ȣ��ֽڳ���
		headInfo.append("Content-Length:").append(len).append(CRLF);
		//����֮ǰ
		headInfo.append(CRLF);
		
	
	}
	/**
	 * ���ͳ�ȥ
	 * @param code
	 * @throws IOException 
	 */
	void pushToClient(int code) throws IOException{
		if(null==headInfo){
			
			code=500;
		}
		createHeadInfo(code);
		//ͷ��Ϣ+�ָ���
		bw.append(headInfo.toString());
		//����
		bw.append(content.toString());
		bw.flush();
		
	}
	public void close(){
		CloseUtil.Close(bw);
	}
}
