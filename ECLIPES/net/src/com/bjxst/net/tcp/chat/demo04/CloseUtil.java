package com.bjxst.net.tcp.chat.demo04;

import java.io.Closeable;
import java.io.IOException;

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
}
