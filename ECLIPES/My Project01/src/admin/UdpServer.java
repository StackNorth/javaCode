package admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UdpServer extends JFrame implements ActionListener{
	public byte[] buffer = new byte[1024];
	SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
	public Menu menu;
	public MenuItem change;
	public MenuItem quit;
	public MenuBar wenjian;
	public JTextArea area;
	public JScrollPane pane;// �Զ�����
	public JLabel nameLabel;
	public JTextField name;
	public JTextArea areaSend;
	public JButton send;
	int startThread = 0;
	ThreadA serverTextThread;
	String ip = "";
	int sendPort = 1;
	int recPort = 2;
	JPanel panle1=new JPanel();
	JPanel panle2=new JPanel();
	JPanel panle3=new JPanel();
	FileDialog filedialog_load;
	FileDialog filedialog_saveAs;
	public static boolean serverTextThreadTag=true;
	Server connectClient=null;
	String talkServerName;
	public UdpServer(int nowsendPort,String nowip,int nowrecPort,Server getConnectClient,String talkName) {
		setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wenjian = new MenuBar();
		menu = new Menu("ϵͳ");
		change = new MenuItem("����");
		quit = new MenuItem("�˳�");
		menu.add(change);
		menu.add(quit);
		wenjian.add(menu);
		setMenuBar(wenjian);
		quit.addActionListener(this);
		change.addActionListener(this);

		area = new JTextArea("");
		area.setBounds(0, 10, 380, 200);
		area.setSelectedTextColor(Color.RED);
		area.setLineWrap(true);        //�����Զ����й��� 
		area.setWrapStyleWord(true);            // ������в����ֹ���
		area.disable();
		area.setDisabledTextColor(Color.blue);
		pane = new JScrollPane();
		pane.setBounds(0, 10, 380, 200);
		pane.getViewport().add(area, null);
		this.add(pane);

		//��ֵ�Ự�ǳ�
		talkServerName=talkName;
		
		nameLabel = new JLabel("�ǳƣ�");
		nameLabel.setBounds(10, 213, 100, 20);
		name = new JTextField(131);
		name.setBounds(45, 213, 100, 20);
		name.setText(talkServerName);
		name.disable();
		name.setDisabledTextColor(Color.red);
		this.add(nameLabel);
		this.add(name);
		nameLabel.setVisible(false);
		name.setVisible(false);

		areaSend = new JTextArea("");
		areaSend.setBounds(0, 234, 380, 150);
		
		areaSend.setSelectedTextColor(Color.RED);
		areaSend.setLineWrap(true);        //�����Զ����й��� 
		areaSend.setWrapStyleWord(true);            // ������в����ֹ���
		this.add(areaSend);
		
		
		
		filedialog_load=new FileDialog(this,"",FileDialog.LOAD);//ע����������
		filedialog_saveAs=new FileDialog(this,"",FileDialog.SAVE);
	
		send = new JButton("����");
		send.setBounds(230, 388, 100, 30);
		this.add(send);
		send.addActionListener(this);

		this.setVisible(true);
		this.setBounds(250, 100, 400, 500);
		this.setTitle(name.getText()+" �ķ������Ự����");
		connectClient=getConnectClient;

		ip = nowip;
		sendPort=nowsendPort;
		recPort=nowrecPort;
		
		// ����һ���̼߳����˿� Ȼ���ȡ��Ϣ
		if(serverTextThread==null){
			serverTextThread = new ThreadA() ;
			serverTextThread.start();
			System.out.println("�Ѿ����������������ն˿ں��� ��"+recPort+"\n");
			
		}
									
		//��ӹرմ����¼�
		this.addWindowListener(new WindowAdapter(){
    		public void windowClosing(WindowEvent event)
    		{
    			try {
    				if(serverTextThread!=null){
    					serverTextThread.interrupt();
    				}					
														
				} catch (RuntimeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (Exception ee){
					
				}
				dispose();
				System.exit(0);
    		}
		});
	}
	
	public void actionPerformed(ActionEvent e) {//���͵����ն�
		// TODO Auto-generated method stub
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		String mess="";
		byte[] bytes=null;
		if(e.getSource()==send){
			String message=name.getText().trim();
			if(!message.equals("")){
				try{
					
					Date date=new Date();
					mess=name.getText().trim()+" "+dateformat.format(date)+"\n";
					mess=mess+areaSend.getText();
					bytes=mess.getBytes();
					ds = new DatagramSocket();
					dp = new DatagramPacket(bytes, bytes.length, InetAddress
							.getByName(ip), sendPort);
					ds.send(dp);
					ds.close();
					ds = null;
					dp = null;
					System.out.println("������Ϣ���ͻ��ˣ� "+sendPort+" ��Ϣ  "+mess);
					area.append(mess+"\n");
					areaSend.setText("");
					setMouse();
				}catch(Exception ee){   
					try {
						if (ds != null) {
							ds.close();
							ds = null;
						}
					} catch (Exception eee) {
					}
					try {
						if (dp != null) {
							dp = null;
						}
					} catch (Exception ee3e) {
					}
				}
			}
			}else if(e.getSource()==quit){//�˳�
					serverTextThread.interrupt();
					serverTextThreadTag=false;
			
					this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					dispose();
						System.exit(0);
					//throw new InterruptedException(){};												
			}else if(e.getSource()==change){		
					try {
						Thread.sleep(10);
						this.stopThread();
						} catch (Exception esss) {
						esss.printStackTrace();
						}
					this.setVisible(false);
					serverTextThreadTag=false;
					connectClient.setVisible(true);
					connectClient.setShowTag(true, this);
			}
	}
	
	
	//file�Ĺ��
	public void setMouse(){
		int height = 20;
	     Point p = new Point();
	     p.setLocation(0, area.getLineCount() * height);
	     pane.getViewport().setViewPosition(p);
	}
	//�����µ� ip port
	public void setNewIpPort(String nowip, int nowsendport,int nowrecport,Server getConnectClient,String talkName) {
		ip = nowip;
		sendPort = nowsendport;
		recPort = nowrecport;
		connectClient=getConnectClient;
		//System.out.println(serverTextThread.getState());
		talkServerName=talkName;
		name.setText(talkServerName);
		if(serverTextThread==null){
			serverTextThread=new ThreadA();
			serverTextThread.start();
		}
	
		System.out.println(serverTextThread.getState());
		String state=serverTextThread.getState().toString();
		serverTextThreadTag=true;
		
		
	}
	public static void main(String[] args) {
		//new TalkFrameServer(1, "localhost", 3, 4,1,2,new JLabelDemoServer());
		new UdpServer(11,"localhost",22,new Server(),"������") ;
	}
	
	protected class ThreadA extends Thread{
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			try {
				while (true) {
					try {
						ds = new DatagramSocket(recPort);
						dp = new DatagramPacket(buffer, buffer.length);
						ds.receive(dp);
						String info = new String(dp.getData(), 0, dp.getLength());
						System.out.println("�յ���Ϣ �ͻ������� " + info);
						area.append(info+"\n");
						ds.close();
						ds = null;
						dp = null;
					} catch (IOException e) {
						try {
							if (ds != null) {
								ds.close();
								ds = null;
							}
						} catch (Exception eee) {
						}
						try {
							if (dp != null) {
								dp = null;
							}
						} catch (Exception ee3e) {
						}
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void interrupt() {
		// TODO Auto-generated method stub
		try {
			System.out.println("�ܹ���߳� "+Thread.activeCount());
			super.stop();
			System.out.println("==============��������ֹͣ !");
		} catch (Exception e) {
		}
		System.out.println("��ǰ״̬�� "+serverTextThread.getState()+" "+serverTextThread.getId());
		}
	}
	
	public void stopThread() {
		if (serverTextThread != null) {
			serverTextThread.interrupt();
			serverTextThread = null;
		}
		
	}
}
