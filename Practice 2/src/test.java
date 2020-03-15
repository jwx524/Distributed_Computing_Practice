import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class test {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("in:");
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
		for(int i=0;i<temp.length();i++) {
			System.out.print((byte)m[i]);
		}
		System.out.println();
		String s2=new String(m);
		System.out.println(s2);
		char op=s2.charAt(0);
		System.out.println(op);
		String n1=null;
		String n2=null;
		int index = 0;
		for(int i=2;i<s2.length();i++) {
			if(s2.charAt(i)=='\n') {
				index=i;
				break;
			}
		}
		n1=s2.substring(2,index);
		n2=s2.substring(index+1,s2.length()-1);
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(s2.length());
		int a = Integer.parseInt(n1);
		int b = Integer.parseInt(n2);
		int c=0;
		if(op=='+') c=a+b;
		else if (op=='-') c=a-b;
		else if(op=='*') c=a*b;
		else if(op=='/') c=a/b;
		else c=0;
	}



}
