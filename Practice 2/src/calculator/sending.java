package calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.util.concurrent.LinkedBlockingQueue;

public class sending {
	public static LinkedBlockingQueue<unit> out=new LinkedBlockingQueue<unit>();	
	public static void main(String[] args) throws InterruptedException {
		// TODO �Զ����ɵķ������
		while(true){
			sthread t=new sthread();
			t.start();
		}
	}

}
