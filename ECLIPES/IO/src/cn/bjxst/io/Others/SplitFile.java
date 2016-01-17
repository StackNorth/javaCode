package cn.bjxst.io.Others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SplitFile{
	//分割后的字符串
	private String destBlockPath;
	//文件路径
	private String filePath;
	//块数
	private int size;
	//每块的大小
	private long blockSize;
	//文件名字
	private String fileName;
	//每块的名称 
	private List<String> blockPath;
	//文件大小
	private long length;
	public SplitFile(){
		blockPath=new ArrayList<String>();		
	}
	public SplitFile(String filePath,String destBlockPath){
		this(filePath,destBlockPath,1024); 	
	}
	public SplitFile(String filePath,String destBlockPath,long blockSize){
		this(); 
		this.destBlockPath=destBlockPath;
		this.filePath=filePath;
		this.blockSize=blockSize;
		init();
	}
	/**
	 * 初始化操作，计算块数，确定文件名	
	 */
	public void init(){
		File src =null;
		//为了程序的健壮性
		if(null==filePath || !(((src=new File(filePath)).exists()))){
			return;
		}
		if(src.isDirectory()){
			return ;
		}
		this.fileName=src.getName();//文件名
		//计算块数  实际大小与每块大小
		 this.length=src.length();//实际大小
		//修正每块大小
		if(this.blockSize>length){
			this.blockSize=length;
		}
		//确定块数
		size= (int)(Math.ceil(length*1.0/this.blockSize));
		initPathName();
	}
	/**
	 * 分割文件的名称
	 */
	private void initPathName(){
		 for(int i=0;i<size;i++){
			 this.blockPath.add(destBlockPath+"/"+this.fileName+".path"+i);
		 }
	}
	/**
	 * 文件的分割
	 * 0第几块
	 * 1起始位置
	 * 2实际大小 
	 * @param destPath 分割文件的存放目录
	 */
	public void split(){
		
		long beginPos=0;//起始点
		long actualBlockSize=this.blockSize;//实际大小
	//计算所有块的大小，位置，索引
		for(int i=0;i<size;i++){
			if(i==size-1){
				actualBlockSize=this.length-beginPos;
			}
			splitDetail(i,beginPos,actualBlockSize);
			beginPos+=actualBlockSize;//下一次起点
		}
	}
	/**
	 * 文件的分割  输入   输出
	 * 文件的拷贝
	 * @param idx 第几块
	 * @param beginPos 起始点
	 * @param actualBlockSize 实际大小
	 */
	public void splitDetail(int idx,long beginPos,long actualBlockSize){
		//创建源
		File src =new File(this.filePath);//源文件
		File dest= new File(this.blockPath.get(idx));//目标文件
		 RandomAccessFile raf=null;//输入流
		 BufferedOutputStream bos= null;//输出流
		 try {
			 bos= new BufferedOutputStream(new FileOutputStream(dest));
			 raf=new RandomAccessFile(src,"r");
			 //读取文件
			 raf.seek(beginPos);
			 //缓冲区
			 byte[] flush=new byte[1024];
			 int len=0;
			 while(-1!=(len=raf.read(flush))){
				 if(actualBlockSize-len>=0){//查看是否足够
					 bos.write(flush,0,len);
					 actualBlockSize-=len;//剩余量
				 }else{//写出最后一次的剩余量
					 bos.write(flush,0,(int)actualBlockSize);
					 break;
				 }
				 
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			FileUtil.close(raf,bos);
		}
	}
	
	/**
	 * 文件的合并
	 */
	public void meregFile(String destPath){
		//创建源
		File dest=new File(destPath);
		//选择流
		BufferedOutputStream bos=null;//输出流
		//创建一个容器
		Vector<InputStream> vi=new Vector<InputStream>(); 
		SequenceInputStream sis=null; 
		
		try {
			for(int i=0;i<this.blockPath.size();i++){
				vi.add(new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i)))));
			}
		
			bos= new BufferedOutputStream(new FileOutputStream(dest,true));//必须已追加方式
			sis=new SequenceInputStream(vi.elements());
		for(int i=0;i<this.blockPath.size();i++){
				byte[] flush= new byte[1024];
				int len=0;
				while(-1!=(len=sis.read(flush))){
					bos.write(flush,0,len);
				}
				bos.flush();
				FileUtil.closeAll(sis);
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			FileUtil.closeAll(bos); 
		}
	}
	
	
	
	/**
	 * 文件的合并
	 * @param args
	 */
	public void meregFile1(String destPath){
		//创建源
		File dest=new File(destPath);
		BufferedOutputStream bos=null;
		try {
			bos= new BufferedOutputStream(new FileOutputStream(dest,true));//必须已追加方式
			BufferedInputStream bis=null;
		for(int i=0;i<this.blockPath.size();i++){
				bis=new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i))));
				byte[] flush= new byte[1024];
				int len=0;
				while(-1!=(len=bis.read(flush))){
					bos.write(flush,0,len);
				}
				bos.flush();
				FileUtil.closeAll(bis);
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			FileUtil.closeAll(bos); 
		}
	}
	
	
	public static void main(String[] args) {
		SplitFile split =new SplitFile("E:/t/test.txt","E:/t",600);
		//split.split();
		split.meregFile("E:/t/test1.java");
	}
}
