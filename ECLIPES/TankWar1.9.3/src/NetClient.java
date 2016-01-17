import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class NetClient {
	TankClient tc;
	private static  int UDP_START_PORT = 2223;
	private int udpPort;
	public NetClient(TankClient tc) {
		udpPort = UDP_START_PORT++;
		this.tc = tc;
	}
	public void connect(String IP,int port){
		Socket s = null;//防止updport写入错误后,socket不能正常关闭
		try {
			 s = new Socket(IP, port);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeInt(udpPort);
			DataInputStream dis = new DataInputStream(s.getInputStream());
			tc.myTank.ID = dis.readInt();
			System.out.println("Client to server! and server give me a ID："+tc.myTank.ID);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(s != null){
				try {
					s.close();
					s = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
}
