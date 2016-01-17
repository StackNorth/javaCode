package cn.bjsxt.test;

import java.io.*;

public class A {
	public void method() throws IOException{
		
	}
}	
	class B extends A{
		public void method() throws FileNotFoundException{
		}	
	}	
		
	class C extends A{
			public void method() throws IOException{
				
			}
	}	
			

