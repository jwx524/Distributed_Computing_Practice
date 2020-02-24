package TCP∂‡œﬂ≥Ã;
import java.io.*;
import java.net.*;

public class EchoServer {
	 public static void main(String[] args) throws Exception {
		Socket clientSocket = null;
		ServerSocket listenSocket = new ServerSocket(8189); 
				
		System.out.println("Server listening at 8189");
		while(true) {
			clientSocket = listenSocket.accept();
			System.out.println("Accepted connection from client");
		
			TCPThread t=new TCPThread(clientSocket);
			t.start();
		}
	 }
}