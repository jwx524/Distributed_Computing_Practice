package UDP���߳�;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer{

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
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
