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
	//�ָ����ַ���
	private String destBlockPath;
	//�ļ�·��
	private String filePath;
	//����
	private int size;
	//ÿ��Ĵ�С
	private long blockSize;
	//�ļ�����
	private String fileName;
	//ÿ������� 
	private List<String> blockPath;
	//�ļ���С
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
	 * ��ʼ�����������������ȷ���ļ���	
	 */
	public void init(){
		File src =null;
		//Ϊ�˳���Ľ�׳��
		if(null==filePath || !(((src=new File(filePath)).exists()))){
			return;
		}
		if(src.isDirectory()){
			return ;
		}
		this.fileName=src.getName();//�ļ���
		//�������  ʵ�ʴ�С��ÿ���С
		 this.length=src.length();//ʵ�ʴ�С
		//����ÿ���С
		if(this.blockSize>length){
			this.blockSize=length;
		}
		//ȷ������
		size= (int)(Math.ceil(length*1.0/this.blockSize));
		initPathName();
	}
	/**
	 * �ָ��ļ�������
	 */
	private void initPathName(){
		 for(int i=0;i<size;i++){
			 this.blockPath.add(destBlockPath+"/"+this.fileName+".path"+i);
		 }
	}
	/**
	 * �ļ��ķָ�
	 * 0�ڼ���
	 * 1��ʼλ��
	 * 2ʵ�ʴ�С 
	 * @param destPath �ָ��ļ��Ĵ��Ŀ¼
	 */
	public void split(){
		
		long beginPos=0;//��ʼ��
		long actualBlockSize=this.blockSize;//ʵ�ʴ�С
	//�������п�Ĵ�С��λ�ã�����
		for(int i=0;i<size;i++){
			if(i==size-1){
				actualBlockSize=this.length-beginPos;
			}
			splitDetail(i,beginPos,actualBlockSize);
			beginPos+=actualBlockSize;//��һ�����
		}
	}
	/**
	 * �ļ��ķָ�  ����   ���
	 * �ļ��Ŀ���
	 * @param idx �ڼ���
	 * @param beginPos ��ʼ��
	 * @param actualBlockSize ʵ�ʴ�С
	 */
	public void splitDetail(int idx,long beginPos,long actualBlockSize){
		//����Դ
		File src =new File(this.filePath);//Դ�ļ�
		File dest= new File(this.blockPath.get(idx));//Ŀ���ļ�
		 RandomAccessFile raf=null;//������
		 BufferedOutputStream bos= null;//�����
		 try {
			 bos= new BufferedOutputStream(new FileOutputStream(dest));
			 raf=new RandomAccessFile(src,"r");
			 //��ȡ�ļ�
			 raf.seek(beginPos);
			 //������
			 byte[] flush=new byte[1024];
			 int len=0;
			 while(-1!=(len=raf.read(flush))){
				 if(actualBlockSize-len>=0){//�鿴�Ƿ��㹻
					 bos.write(flush,0,len);
					 actualBlockSize-=len;//ʣ����
				 }else{//д�����һ�ε�ʣ����
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
	 * �ļ��ĺϲ�
	 */
	public void meregFile(String destPath){
		//����Դ
		File dest=new File(destPath);
		//ѡ����
		BufferedOutputStream bos=null;//�����
		//����һ������
		Vector<InputStream> vi=new Vector<InputStream>(); 
		SequenceInputStream sis=null; 
		
		try {
			for(int i=0;i<this.blockPath.size();i++){
				vi.add(new BufferedInputStream(new FileInputStream(new File(this.blockPath.get(i)))));
			}
		
			bos= new BufferedOutputStream(new FileOutputStream(dest,true));//������׷�ӷ�ʽ
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
	 * �ļ��ĺϲ�
	 * @param args
	 */
	public void meregFile1(String destPath){
		//����Դ
		File dest=new File(destPath);
		BufferedOutputStream bos=null;
		try {
			bos= new BufferedOutputStream(new FileOutputStream(dest,true));//������׷�ӷ�ʽ
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
