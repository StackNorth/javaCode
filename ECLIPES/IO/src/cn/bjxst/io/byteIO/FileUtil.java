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
	 * �ļ�����
	 * @param src Դstring����
	 * @param destĿ��string����
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
	 * @param src ԴFIle����
	 * @param destĿ��File����
	 */
	public static void copyDir(File src, File dest){
		if(src.isDirectory()){
			dest=new File(dest,src.getName());	
			if(dest.getAbsolutePath().contains(src.getAbsolutePath()))
				System.out.println("��Ŀ¼���ܿ�������Ŀ¼��");
				return;
		}
		copyDirDetail(src,dest);
		
	}
/**
 *�����ļ���
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
			//ȷ��Ŀ���ļ��д���
			dest.mkdirs();
			//��ȡ��һ��Ŀ¼���ļ�
			for(File sub:src.listFiles()){
				copyDirDetail(sub,new File(dest,sub.getName()));
			}
		}	
	}
	
	
	public static void CopyFile(String srcPath,String destPath) throws IOException {
		File src = new File(srcPath);
		File str = new File(destPath);
		if(!src.isFile()){
			throw new IOException("ֻ�ܿ����ļ�");
			
		}
		InputStream is =new BufferedInputStream (new FileInputStream(srcPath));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath));
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))){
			os.write(flush, 0, len);
		}
		os.flush();//ǿ��ˢ��
		os.close();
		is.close();
	}
	public static void CopyFile(File src,File dest) throws IOException {
		if(!src.isFile()){
			throw new IOException("ֻ�ܿ����ļ�");
		}
		
		if(dest.isDirectory()){
			throw new IOException("���ܽ������ļ���ͬ�����ļ�");
		}
		InputStream is =new BufferedInputStream (new FileInputStream(src));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))){
			os.write(flush, 0, len);
		}
		os.flush();//ǿ��ˢ��
		os.close();
		is.close();
	}
	
	
}
