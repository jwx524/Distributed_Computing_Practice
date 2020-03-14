package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class rthread extends Thread{
	DatagramSocket aSocket =null;
	DatagramPacket request = null;
	rthread(DatagramSocket ds,DatagramPacket r) throws IOException{
		aSocket = ds;
		request=r;
	}
	public void run() {
		/*	DatagramPacket reply = new DatagramPacket(request.getData(),
		request.getLength(), request.getAddress(), request.getPort());
		aSocket.send(reply);
		byte[] m=request.getData();*/
		unit u=new unit(aSocket,request);
		try {
			server.in.put(u);
			System.out.println("enqueue");
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
