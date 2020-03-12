package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class sthread extends Thread{
	DatagramSocket aSocket =null;
	DatagramPacket request = null;
	sthread() throws InterruptedException{
		unit u=null;
		u=sending.out.take();
		aSocket = u.aSocket;
		request=u.request;
	}
	public void run() {
		DatagramPacket reply = new DatagramPacket(request.getData(),
		request.getLength(), request.getAddress(), request.getPort());
		try {
			aSocket.send(reply);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		/*byte[] m=request.getData();
		unit u=new unit(aSocket,request);
		try {
			receive.in.put(u);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}*/
	}
}
