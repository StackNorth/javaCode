import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;


public class TankServer {
	public static final int TCP_PORT = 8888;
	public static final int UDP_PORT = 6666;
	private static int ID = 100;
	List<Client> clients = new ArrayList<Client>();
	public void start(){
		ServerSocket ss =null;
		try {
			ss = new ServerSocket(TCP_PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true){
			Socket s = null;
			try{
				s= ss.accept();
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String IP = s.getInetAddress().getHostAddress();
				int udpPort = dis.readInt();
				Client c = new Client(IP,udpPort);
				DataOutputStream dos =new DataOutputStream(s.getOutputStream());
				dos.writeInt(ID++);
				clients.add(c);
				System.out.println("A Client Connect! -Addr£º"+s.getInetAddress()+":"+s.getPort()+"---->UDP:"+udpPort);
				
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				try {
					s.close();
					s = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
	}
	public static void main(String[] args) {
		new TankServer().start();
	}
private class Client{
	String IP;
	int udpPort;
	public Client(String iP, int udpPort) {
		IP = iP;
		this.udpPort = udpPort;
	}
	
	
	
}
private class UDPThread implements Runnable{
	byte[] buf = new byte[1024];
	DatagramSocket ds= null;
	public void run() {
		try {
			ds = new DatagramSocket();
System.out.println("UDP thread started at port: "+UDP_PORT);			
		} catch (SocketException e) {
			e.printStackTrace();
		}
		while(ds != null){
			DatagramPacket dp = new DatagramPacket(buf,buf.length);
			try {
				ds.receive(dp);
System.out.println("a packet received!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}


}
