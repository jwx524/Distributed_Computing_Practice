//package rmiclient;

import java.rmi.registry.LocateRegistry;

import java.rmi.registry.Registry;
import java.util.Scanner;



public class MyRMIClient {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		try {
            String name = "RMIBook";
            String serverIP = "127.0.0.1";  
            int serverPort = 1099;
			Registry registry = LocateRegistry.getRegistry(serverIP, serverPort);
			MyBook mb = (MyBook) registry.lookup(name);
        /*    book temp = new book(1,"First Book");
            mb.add(temp);
            book idResult = mb.queryById(1);
            System.out.println(idResult.toString());
            booklist nameResult = mb.queryByName("First Book");
            System.out.println(nameResult.toString());
            mb.delete(1);*/
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("��ѡ���ܣ�1����鼮 2ID��ѯ 3����ģ������ 4ɾ���鼮 5�˳�");
	            int choice = sc.nextInt();
	            switch(choice) {
            	case 1:
            		System.out.println("����������鼮��ID��");
            		int bkID = sc.nextInt();
            		System.out.println("����������鼮��������");
            		String bkName = sc.next();
            		book temp = new book(bkID , bkName);
            		boolean p = mb.add(temp);
            		if(p) {
            			System.out.println(bkID+":"+bkName+" �����");
            		}
            		else {
            			System.out.println(bkID+":"+" �Ѵ���");
            		}
            		break;
            	case 2:
            		System.out.println("�������ѯ�鼮��ID��");
            		int searchID = sc.nextInt();
            		book idResult = mb.queryById(searchID);
            		if(idResult!=null) {
            			System.out.println(searchID+":"+idResult.getName());
            		}
            		else {
            			System.out.println(searchID+" δ�ҵ�");
            		}
            		System.out.println(idResult.toString());
            		break;
            	case 3:
            		System.out.println("������ģ�������鼮��������");
            		String searchName = sc.next();
            		booklist nameResult = mb.queryByName(searchName);
            		book temp2=new book();
            		for(int i=0;i<nameResult.list.size();i++) {
            			temp2 = nameResult.list.get(i);
            			System.out.println(temp2.getId()+":"+temp2.getName());
            		}
            		System.out.println(nameResult.toString());
            		break;
            	case 4:
            		System.out.println("������ɾ���鼮��ID��");
            		int deleteID = sc.nextInt();
            		boolean p2 = mb.delete(deleteID);
             		if(p2) {
             			System.out.println(deleteID+" ��ɾ��");
             		}
             		else {
             			System.out.println(deleteID+" ������");
             		}
            		break;
            	case 5:
            		return;
	            }
			}
        } catch (Exception e) {
            System.err.println("??? exception:");
            e.printStackTrace();
        }
	}

}
