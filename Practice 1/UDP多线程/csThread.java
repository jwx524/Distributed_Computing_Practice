package UDP���߳�;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class csThread extends Thread{
	DatagramSocket aSocket =null;
	byte[] buffer = new byte[1000];
	csThread(DatagramSocket ds) throws IOException{
		aSocket = ds;
	}
	public void run() {
		try {
			DatagramPacket request = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(request);
			DatagramPacket reply = new DatagramPacket(request.getData(),
			request.getLength(), request.getAddress(), request.getPort());
			aSocket.send(reply);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
