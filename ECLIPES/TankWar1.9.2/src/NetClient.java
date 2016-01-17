import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class NetClient {
	
	private static  int UDP_START_PORT = 2223;
	private int udpPort;
	public NetClient() {
		udpPort = UDP_START_PORT++;
	}
	public void connect(String IP,int port){
		Socket s = null;//防止updport写入错误后,socket不能正常关闭
		try {
			 s = new Socket(IP, port);
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.write(udpPort);
			
			System.out.println("Client to server!");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(s != null){
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
}
