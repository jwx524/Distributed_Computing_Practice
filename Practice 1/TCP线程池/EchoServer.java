package TCPÏß³Ì³Ø;
import java.io.*;
import java.net.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EchoServer {
	 public static void main(String[] args) throws Exception {
		Socket clientSocket = null;
		int count=0;
		ServerSocket listenSocket = new ServerSocket(8189); 
				
		System.out.println("Server listening at 8189");
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
		while(true) {
			clientSocket = listenSocket.accept();
			System.out.println("Accepted connection from client");
			count++;
			System.out.println("The total number of clients is " + count + ".");
			TCPThread t=new TCPThread(clientSocket);
			executor.execute(t);
			System.out.println("The number of threads in the ThreadPool:"+executor.getPoolSize());
			System.out.println("The number of tasks in the Queue:" + executor.getQueue().size());
            System.out.println("The number of tasks completed:"+executor.getCompletedTaskCount());
		}
	 }
}