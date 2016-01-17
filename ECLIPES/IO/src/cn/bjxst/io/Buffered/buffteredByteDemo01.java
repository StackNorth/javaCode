package cn.bjxst.io.Buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 *字节流文件拷贝 +缓冲流 提高性能
 *缓冲流+（节点流）
 * @author llf
 *
 */
public class buffteredByteDemo01 {
	public static void CopyFile(String srcPath,String destPath) throws IOException {
		File src = new File(srcPath);
		File str = new File(destPath);
		if(!src.isFile()){
			throw new IOException("只能拷贝文件");
			
		}
		InputStream is =new BufferedInputStream(new FileInputStream(srcPath));
		OutputStream os =new  BufferedOutputStream(new FileOutputStream(destPath));
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
