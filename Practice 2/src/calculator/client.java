package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class client {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket();
			System.out.println("请输入：");
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String oprt=stdIn.readLine();
			String num=stdIn.readLine();	
			String num2=stdIn.readLine();
			String s="\n";
			String temp=oprt+s;
			temp=temp+num;
			temp=temp+s;
			temp=temp+num2;
			temp=temp+s;
			byte[] m = temp.getBytes();
			InetAddress aHost = InetAddress.getByName("127.0.0.1");
			int serverPort = 6789;
			DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
			aSocket.send(request);
			System.out.println("数据包已发送。");
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			System.out.println("Reply: " + new String(reply.getData()));
		} catch (SocketException e){
			System.out.println("Socket: " + e.getMessage());
	    } catch (IOException e){
			System.out.println("IO: " + e.getMessage());
	    } finally { 
		    if(aSocket != null) aSocket.close();
		}
	}

}
