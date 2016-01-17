package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener {

	private JPanel pane;
	public JTextField ipName;
	public JLabel ip;
	public JLabel textRecievePort;
	public JTextField textRecievePortName;
	public JLabel textSendPort;
	public JTextField textSendPortName;
	public JLabel talk;
	public JTextField talkName;
	public JButton button;
	public static boolean showTag=false;
	public UdpClient talkClient;
	public Client() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = new JPanel(); // �������
		textRecievePort = new JLabel("����˿ںţ�");
		textRecievePort.setBounds(120, 110, 100, 100);
		textRecievePortName = new JTextField(11);
		textRecievePortName.setText("22");
		textRecievePortName.setBounds(220, 110, 100, 100);
		ip = new JLabel("�Է���IP��ַ:");
		ip.setBounds(120, 310, 100, 100);
		ipName = new JTextField(11);
		ipName.setBounds(220, 310, 100, 100);
		ipName.setText("localhost");
		
		textSendPort = new JLabel("����˿ںţ�");
		textSendPort.setBounds(120, 410, 100, 100);
		textSendPortName = new JTextField(11);
		textSendPortName.setText("11");
		textSendPortName.setBounds(220, 410, 100, 100);
		
		talk = new JLabel("����ǳ��ǣ�");
		talk.setBounds(120, 510, 100, 100);
		talkName = new JTextField(11);
		talkName.setText("");
		talkName.setBounds(220, 510, 100, 100);
		
		button = new JButton("����");
		button.setBounds(200, 350, 100, 100);
		pane.add(textRecievePort);
		pane.add(textRecievePortName);
		pane.add(ip);
		pane.add(ipName);	
		pane.add(textSendPort);
		pane.add(textSendPortName);
		pane.add(talk);
		pane.add(talkName);
		pane.add(button);
		button.addActionListener(this);
		/*
		 * pane.add(btn2); pane.add(btn3); // �������ӵ������
		 */
		this.add(pane); // �������ӵ�����
		this.setVisible(true);
		this.setBounds(650, 100, 280, 400);
		this.setTitle("�ҵ�����ͻ��˵�¼����");
		//��ӹرմ����¼�
		this.addWindowListener(new WindowAdapter(){
    		public void windowClosing(WindowEvent event)
    		{
				System.exit(0);
    		}
		});
	}
	public void actionPerformed(ActionEvent g){   
		 if(g.getSource()==button){//����
			 int errTag=0;
			 int recieveTextPort =0;
			 int sendTextPort=0;
			 DatagramSocket ds = null;
			 DatagramPacket dp = null;
			 String ip="";
				try {
					
					ip = ipName.getText().trim();
					try{
						recieveTextPort=Integer.parseInt(textRecievePortName.getText().trim());
					}catch(Exception e){

						JOptionPane.showMessageDialog(this,"�����������˿ں�����!","������ʾ",JOptionPane.ERROR_MESSAGE);
						errTag=1;
					}
					
					
					if(errTag==0){
						if((ip.equals("localhost") || ip.equals("127.0.0.1"))){
							errTag=0;
						}else if(!Pattern.compile("\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}\\.\\d{0,3}").matcher(ip).matches()){
							JOptionPane.showMessageDialog(this,"������ĶԷ�IP��ַ����!","������ʾ",JOptionPane.ERROR_MESSAGE);
							errTag=1;
							//int i=JOptionPane.showConfirmDialog(null,"���浽:"+getTitle(),"����",JOptionPane.YES_NO_OPTION);
						}
						if(errTag==0){//Ŀ���ı��˿�
							try{
								System.out.println(textSendPortName.getText().trim());
								sendTextPort=Integer.parseInt(textSendPortName.getText().trim());
							}catch(Exception e){
								JOptionPane.showMessageDialog(this,"�����������˿ں�����!","������ʾ",JOptionPane.ERROR_MESSAGE);
								errTag=1;
							}
							
						}
						
						if(errTag==0){
							String name=talkName.getText().trim();
							if(name==null || name.equals("")){
								JOptionPane.showMessageDialog(this,"���ĻỰ�ǳƲ���Ϊ��!","������ʾ",JOptionPane.ERROR_MESSAGE);
								errTag=1;
							}
						}
						
						if(errTag==0){
				
								byte[] bytes="".getBytes();
								ds = new DatagramSocket();
								dp = new DatagramPacket(bytes, bytes.length, InetAddress
										.getByName(ip), sendTextPort);
								//ds.send(dp);
								ds.close(); 
								ds = null;
								dp = null;								
							
							this.setVisible(false);	
							this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							this.dispose();
							if(showTag==true){//��ʾ��ʾ
								this.talkClient.setNewIpPort(ip,sendTextPort,recieveTextPort,this,talkName.getText().trim());
								this.talkClient.setVisible(true);
								this.talkClient.area.setText("");
							}else{
								showTag=false;
								new UdpClient(sendTextPort,ip,recieveTextPort,this,talkName.getText().trim());
							//	new TalkFrameServer(1,ip,sendTextPort,sendFilePort,recieveTextPort,recieceFilePort,this);					
								
							}
							
							
						}
					}
				} catch (Exception ee) {
					if(ds!=null){
						try{
							ds.close();
							ds=null;
						}catch (Exception e) {
						}
					}
					if(dp!=null){
						try{
							dp=null;
						}catch (Exception e) {
						}
					}
					int i=JOptionPane.showConfirmDialog(null,"ip��"+ip+" port "+sendTextPort+" �ϵķ�������û���������Ƿ���Ҫ������","����",JOptionPane.YES_NO_OPTION);
					if(i==1){
						
					}else{
						this.setVisible(false);	
						this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						this.dispose();
						if(showTag==true){//��ʾ��ʾ
							this.talkClient.setNewIpPort(ip,sendTextPort,recieveTextPort,this,talkName.getText().trim());
							this.talkClient.setVisible(true);
							this.talkClient.area.setText("");
							
						}else{
							showTag=false;
							new UdpClient(sendTextPort,ip,recieveTextPort,this,talkName.getText().trim());											
						}
					}
				}

			}

		}
	//��ʾ����http://bbs.bccn.net/thread-118338-1-1.html
	//������whileѭ����ʹ��sleep(time)�������������Ȼ����interrupt�����ж�
	public void setShowTag(boolean tag,UdpClient client){
		this.showTag=tag;
		this.talkClient=client;
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
