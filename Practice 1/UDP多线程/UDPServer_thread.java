import java.io.IOException;
import java.net.DatagramSocket;

public class UDPServer_thread{

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		int serverport=6789;
		DatagramSocket aSocket = new DatagramSocket(serverport);
		while(true) {
			csThread t=new csThread(aSocket);
			t.start();
		}
	}

}
