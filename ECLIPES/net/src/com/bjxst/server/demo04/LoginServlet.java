package com.bjxst.server.demo04;

import com.bjxst.server.demo04.Request;
import com.bjxst.server.demo04.Response;

public class LoginServlet extends Servlet{

	@Override
	public void doGet(Request req,Response rep) throws Exception {
		String name= req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		if(login(name,pwd)){
			rep.println("��½�ɹ�");
			
		}else{
			rep.println("��½ʧ��");
		}
	}
	
	public boolean login(String name,String pwd){
		return name.equals("bjxst") && pwd.equals("123456");
		
	}
	@Override
	public void doPost(Request req,Response rep) throws Exception {
		
	}

}
