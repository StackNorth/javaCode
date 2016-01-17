package cn.bjxst.io.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 一：读取文件：
1、建立联系，File对象
2、选择流、文件输入流、InPutStream 

FileInputStream
3、操作：byte[] car=new byte[1024]+read+读

取大小输出
4、关闭

 * @author llf
 *
 */
public class Demo01 {
	
	public static void main(String[] args) {
		File src=new File("E:/Java/test.txt");
		InputStream is=null;
		try {
			 is =new FileInputStream(src);
			// 操作不断读取
				byte[] car=new byte[10];
				int len=0;
				while(-1!=(len=is.read(car))){
					String info = new String(car,0,len);
					System.out.println(info);
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e1) {
			System.out.println("读取文件失败");
			e1.printStackTrace();
		}finally{
				try {
					if(null != is)
					is.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				 }
				
			}
			
		
		}
	}

