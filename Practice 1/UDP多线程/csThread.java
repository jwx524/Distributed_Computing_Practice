package UDP多线程;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class csThread extends Thread{
	DatagramSocket aSocket =null;
	DatagramPacket request = null;
	csThread(DatagramSocket ds,DatagramPacket r) throws IOException{
		aSocket = ds;
		request=r;
	}
	public void run() {
		try {
			DatagramPacket reply = new DatagramPacket(request.getData(),
			request.getLength(), request.getAddress(), request.getPort());
			aSocket.send(reply);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
