package cn.bjxst.io.byteIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	
	/**
	 * 文件拷贝
	 * @param src 源string对象
	 * @param dest目标string对象
	 */
	public static void copyDir(String srcpath, String destpath){
		File src=new File(srcpath);
		File dest=new File(destpath);
		if(src.isDirectory()){
			dest=new File(dest,src.getName());	
		}
		copyDir(src,dest);
		
	}
	/**
	 * 
	 * @param src 源FIle对象
	 * @param dest目标File对象
	 */
	public static void copyDir(File src, File dest){
		if(src.isDirectory()){
			dest=new File(dest,src.getName());	
			if(dest.getAbsolutePath().contains(src.getAbsolutePath()))
				System.out.println("父目录不能拷贝到子目录中");
				return;
		}
		copyDirDetail(src,dest);
		
	}
/**
 *拷贝文件夹
 * @param src
 * @param dest
 */
	public static void copyDirDetail(File src, File dest) {
		if(src.isFile()){
				try {
					FileUtil.CopyFile(src, dest);
				} catch (IOException e) {
					e.printStackTrace();
				}
		}else if(src.isDirectory()){
			//确保目标文件夹存在
			dest.mkdirs();
			//获取下一级目录：文件
			for(File sub:src.listFiles()){
				copyDirDetail(sub,new File(dest,sub.getName()));
			}
		}	
	}
	
	
	public static void CopyFile(String srcPath,String destPath) throws IOException {
		File src = new File(srcPath);
		File str = new File(destPath);
		if(!src.isFile()){
			throw new IOException("只能拷贝文件");
			
		}
		InputStream is =new BufferedInputStream (new FileInputStream(srcPath));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath));
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))){
			os.write(flush, 0, len);
		}
		os.flush();//强制刷出
		os.close();
		is.close();
	}
	public static void CopyFile(File src,File dest) throws IOException {
		if(!src.isFile()){
			throw new IOException("只能拷贝文件");
		}
		
		if(dest.isDirectory()){
			throw new IOException("不能建立与文件夹同名的文件");
		}
		InputStream is =new BufferedInputStream (new FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
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
