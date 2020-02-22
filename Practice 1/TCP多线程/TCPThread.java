package TCP���߳�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPThread extends Thread{
	Socket clientSocket = null;
	TCPThread(Socket s){
		clientSocket=s;
	}
	public void run() {
		
		try {
			InputStream inStream = clientSocket.getInputStream();
			OutputStream outStream = clientSocket.getOutputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
			PrintWriter out = new PrintWriter(outStream);
			
			String line = null;
			while((line=in.readLine())!=null) {
				System.out.println("Message from client:" + line);
				out.println(line);
				out.flush();
			}
			clientSocket.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
}
