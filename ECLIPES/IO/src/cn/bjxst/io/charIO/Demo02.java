package cn.bjxst.io.charIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 文件写出
 * @author llf
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//创建源
		File dest=new File("E:/Java/abc.txt");
		//选择流
		Writer wr=null;
		try {
			wr=new FileWriter(dest,true);
			String str="锄禾日当午\n粒粒真辛苦\n";
			wr.write(str);
			wr.append("地方环境卡萨");
			wr.flush();
		} catch (IOException e) {
			System.out.println("源文件写出失败");
			e.printStackTrace();
		}finally{
			if(null==wr){
				
				try {
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
