package com.bjxst.net.tcp.chat.demo03;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;

public class CloseUtil {
	public static void Close(Closeable ...io){
		for(Closeable temp:io){
			if(null!=temp){
				try {
					temp.close();
				} catch (IOException e) {
				}
			}
			
		}
		
	}
	public static void CloseSocket(ServerSocket socket){
			try {
				if(null!=socket){
				socket.close();
				}
			} catch (IOException e) {
			}		
	}
}
