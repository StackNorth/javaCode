package com.bjxst.server.demo02;

import com.bjxst.server.demo02.Request;
import com.bjxst.server.demo02.Response;

/**
 * 抽象为一个父类
 * @author llf
 *
 */
public abstract class Servlet {
	public void service(Request req,Response rep) throws Exception{
		this.doGet(req,rep);
		this.doPost(req,rep);
	}
	public abstract void doGet(Request req,Response rep)throws Exception;
	public abstract void doPost(Request req,Response rep)throws Exception;
}
