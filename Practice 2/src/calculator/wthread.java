package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class wthread extends Thread{

	unit u =null;
	wthread() throws IOException, InterruptedException{
		u=server.in.take();
		System.out.println("start working");
	}
	public void run() {
		/*	DatagramPacket reply = new DatagramPacket(request.getData(),
		request.getLength(), request.getAddress(), request.getPort());
		aSocket.send(reply);*/
		DatagramPacket r=u.request;
		byte[] m=r.getData();
		String s=new String(m);
		char op=s.charAt(0);
		String n1=null;
		String n2=null;
		int index = 0;
		int index2=0;
		for(int i=2;i<s.length();i++) {
			if(s.charAt(i)=='\n') {
				index=i;
				break;
			}
		}
		for(int i=index+1;i<s.length();i++) {
			if(s.charAt(i)=='\n') {
				index2=i;
				break;
			}
		}
		n1=s.substring(2,index);
		n2=s.substring(index+1,index2);
		System.out.println("操作数1："+n1);
		System.out.println("操作数2："+n2);
		int a = Integer.parseInt(n1);
		int b = Integer.parseInt(n2);
		int c=0;
		if(op=='+') c=a+b;
		else if (op=='-') c=a-b;
		else if(op=='*') c=a*b;
		else if(op=='/') c=a/b;
		else c=0;
		System.out.println("answer："+c);
		String ret=c+"";
		ret=ret+"\n";
		byte[] buf = ret.getBytes();
		DatagramPacket temp = new DatagramPacket(buf, buf.length);
		DatagramPacket reply = new DatagramPacket(temp.getData(),temp.getLength(),
				u.request.getAddress(), u.request.getPort());
		unit u2=new unit(u.aSocket,reply);
		try {
			server.out.put(u2);
			System.out.println("done calculation");
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
