package cn.bjxst.io.Others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BuffereIn {
	public static void main(String[] args) throws IOException {
		InputStream is=System.in;
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		System.out.println("«Î ‰»Î.....");
		String msg=br.readLine();
		System.out.println(msg);
	}
}
