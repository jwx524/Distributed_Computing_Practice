package calculator;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class unit {
	DatagramSocket aSocket =null;
	DatagramPacket request = null;
	unit(){
		aSocket =null;
		request = null;
	}
	unit(DatagramSocket ds,DatagramPacket r){
		aSocket = ds;
		request=r;
	}
}
