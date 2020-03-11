package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.LinkedBlockingQueue;



public class receive {
	public static LinkedBlockingQueue<unit> in=new LinkedBlockingQueue<unit>();	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int serverport=6789;
		
		DatagramSocket aSocket=null;
		try{
			aSocket = new DatagramSocket(serverport);
			while(true){
				byte[] buffer = new byte[1000];
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				rthread t=new rthread(aSocket,request);
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
