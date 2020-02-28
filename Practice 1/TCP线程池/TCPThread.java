package TCP线程池;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPThread implements Runnable{
	Socket clientSocket = null;
	TCPThread(Socket s){
		clientSocket=s;
	}
	public void run() {
		InputStream inStream = null;
		OutputStream outStream = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			inStream = clientSocket.getInputStream();
			outStream = clientSocket.getOutputStream();
			in = new BufferedReader(new InputStreamReader(inStream));
			out = new PrintWriter(outStream);
			
			String line = null;
			while((line=in.readLine())!=null) {
				System.out.println("Message from client:" + line);
				out.println(line);
				out.flush();
			}
			clientSocket.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				if(clientSocket!=null) clientSocket.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}
}
