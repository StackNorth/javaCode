package cn.bjxst.io.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {
	
	public static void main(String[] args) {
		String src = "E:/Java/test.txt";
		String str = "E:/Java/test1.txt";
		try {
			CopyFile(src,str);
		} catch (IOException e) {
			System.out.println("拷贝文件失败");
			e.printStackTrace();
		}
	}
	
	
	
	public static void CopyFile(String srcPath,String destPath) throws IOException {
		File src = new File(srcPath);
		File str = new File(destPath);
		if(!src.isFile()){
			throw new IOException("只能拷贝文件");
			
		}
		InputStream is =new FileInputStream(srcPath);
		OutputStream os = new FileOutputStream(destPath);
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))){
			os.write(flush, 0, len);
		}
		os.flush();//强制刷出
		os.close();
		is.close();
	}
}
