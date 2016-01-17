package cn.bjxst.io.byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo02 {
	public static void main(String[] args) {
		//建立文件联系
	File str=new File("E:/Java/test.txt");
	OutputStream os =null;
	try {
		//已追加形式写出文件必须为true，否则为false
		os= new FileOutputStream(str,true);
		String src="bjsxt is very good!";
		//字符转转换为数组
		byte[] data=src.getBytes();
		//写入
		os.write(data,0,data.length);
		System.out.println("文件成功写入");
		//强制刷新出去，养成习惯
		os.flush();
	} catch (FileNotFoundException e) {
		System.out.println("文件未找到");
		e.printStackTrace();
	} catch (IOException e1) {
		System.out.println("文件写出失败");
		e1.printStackTrace();
	}finally{
		if(null != os)
			try {
				os.close();
			} catch (IOException e) {
				System.out.println("文件关闭异常");
				e.printStackTrace();
			}
		
	}
	
  }
}
