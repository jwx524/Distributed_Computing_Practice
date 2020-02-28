package TCPÏß³Ì³Ø;
import java.io.*;
import java.net.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EchoServer {
	 public static void main(String[] args) throws Exception {
		Socket clientSocket = null;
		ServerSocket listenSocket = new ServerSocket(8189); 
				
		System.out.println("Server listening at 8189");
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
		while(true) {
			clientSocket = listenSocket.accept();
			System.out.println("Accepted connection from client");
		
			TCPThread t=new TCPThread(clientSocket);
			executor.execute(t);
		}
	 }
}