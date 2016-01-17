package admin;
import java.io.IOException;  
import java.net.DatagramPacket;  
import java.net.DatagramSocket;  
import java.net.InetAddress;  
import java.net.InetSocketAddress;  
import java.net.SocketException;   
public class UdpServerSocket {  
    private byte[] buffer = new byte[1024];  
      
    private DatagramSocket ds = null;  
  
    private DatagramPacket packet = null;  
  
    private InetSocketAddress socketAddress = null;  
  
    private String orgIp;  
  
    public UdpServerSocket(String host, int port) throws Exception {  
        socketAddress = new InetSocketAddress(host, port);  
        ds = new DatagramSocket(socketAddress);  
        System.out.println("������������!");  
    }  
      
    public final String getOrgIp() {  
        return orgIp;  
    }  
    public final void setSoTimeout(int timeout) throws Exception {  
        ds.setSoTimeout(timeout);  
    }  
    public final int getSoTimeout() throws Exception {  
        return ds.getSoTimeout();  
    }  
  
    /** 
     * �󶨼�����ַ�Ͷ˿�. 
     * @param host ����IP 
     * @param port �˿� 
     * @throws SocketException 
     */  
    public final void bind(String host, int port) throws SocketException {  
        socketAddress = new InetSocketAddress(host, port);  
        ds = new DatagramSocket(socketAddress);  
    }  
    public final void setLength(int bufsize) {  
        packet.setLength(bufsize);  
    }  
  
    /** 
     * ��÷��ͻ�Ӧ��IP��ַ. 
     * @return ���ػ�Ӧ��IP��ַ 
     */  
    public final InetAddress getResponseAddress() {  
        return packet.getAddress();  
    }  
  
    /** 
     * ��û�Ӧ�������Ķ˿�. 
     * @return ���ػ�Ӧ�������Ķ˿�. 
     * @author <a href="mailto:xiexingxing1121@126.com">AmigoXie</a> 
     * Creation date: 2007-8-16 - ����10:48:56 
     */  
    public final int getResponsePort() {  
        return packet.getPort();  
    }  
  
    /** 
     * �ر�udp������. 
     * @author <a href="mailto:xiexingxing1121@126.com">AmigoXie</a> 
     * Creation date: 2007-8-16 - ����10:49:23 
     */  
    public final void close() {  
        try {  
            ds.close();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
    }  
  
    /** 
     * ���Է���. 
     * @param args 
     * @throws Exception 
     * @author <a href="mailto:xiexingxing1121@126.com">AmigoXie</a> 
     * Creation date: 2007-8-16 - ����10:49:50 
     */  
    public final void response(String info) throws IOException {  
        System.out.println("�ͻ��˵�ַ : " + packet.getAddress().getHostAddress()  
                + ",�˿ڣ�" + 4444);  
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, packet  
                .getAddress(), 4444);  
        dp.setData(info.getBytes());  
        ds.send(dp);  
    }  
    public final String receive() throws IOException {  
        packet = new DatagramPacket(buffer, buffer.length);  
        ds.receive(packet);  
        orgIp = packet.getAddress().getHostAddress();  
        String info = new String(packet.getData(), 0, packet.getLength());  
        System.out.println("������Ϣ��" + info);  
        return info;  
    }  
    public static void main(String[] args) throws Exception {  
        String serverHost = "127.0.0.1";  
        int serverPort = 3333;  
        UdpServerSocket udpServerSocket = new UdpServerSocket(serverHost, serverPort);  
        while (true) {  
            udpServerSocket.receive();  
            udpServerSocket.response("���,�ͻ���!");  
              
        }  
    }  
}  