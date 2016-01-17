import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class TankServer {
	public static final int TCP_PORT = 8888;
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
}
