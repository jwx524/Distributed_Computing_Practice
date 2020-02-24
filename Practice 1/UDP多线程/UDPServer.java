package UDP多线程;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer{

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		int serverport=6789;
		DatagramSocket aSocket=null;
		try{
			aSocket = new DatagramSocket(serverport);
			while(true){
				csThread t=new csThread(aSocket);
				t.start();
			}
		} catch (SocketException e){
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (aSocket != null) aSocket.close();
		}
	}

}
