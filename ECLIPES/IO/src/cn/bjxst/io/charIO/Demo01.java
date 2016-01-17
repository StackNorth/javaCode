package cn.bjxst.io.charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 纯文本读取
 * @author llf
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		//创建源
		File src= new File("D:/java/Dog.java");
		//选择流
		Reader reader=null;
		try {
			reader =new FileReader(src);
			char[] flush=new char[1024];
			int len=0;
				while(-1!=(len=reader.read(flush))){
					String str=new String(flush,0,len);
					System.out.println(str);
				}
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("源文件不存在");
		}catch (IOException e) {
			System.out.println("文件读取失败");
			e.printStackTrace();
		}finally{
			if(null!=reader){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		}
			
	}
}
