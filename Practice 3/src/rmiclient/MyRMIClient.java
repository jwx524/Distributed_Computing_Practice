//package rmiclient;

import java.rmi.registry.LocateRegistry;

import java.rmi.registry.Registry;
import java.util.Scanner;



public class MyRMIClient {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
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
				System.out.println("请选择功能：1添加书籍 2ID查询 3书名模糊查找 4删除书籍 5退出");
	            int choice = sc.nextInt();
	            switch(choice) {
            	case 1:
            		System.out.println("请输入添加书籍的ID：");
            		int bkID = sc.nextInt();
            		System.out.println("请输入添加书籍的书名：");
            		String bkName = sc.next();
            		book temp = new book(bkID , bkName);
            		boolean p = mb.add(temp);
            		if(p) {
            			System.out.println(bkID+":"+bkName+" 已添加");
            		}
            		else {
            			System.out.println(bkID+":"+" 已存在");
            		}
            		break;
            	case 2:
            		System.out.println("请输入查询书籍的ID：");
            		int searchID = sc.nextInt();
            		book idResult = mb.queryById(searchID);
            		if(idResult!=null) {
            			System.out.println(searchID+":"+idResult.getName());
            		}
            		else {
            			System.out.println(searchID+" 未找到");
            		}
            		System.out.println(idResult.toString());
            		break;
            	case 3:
            		System.out.println("请输入模糊查找书籍的书名：");
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
            		System.out.println("请输入删除书籍的ID：");
            		int deleteID = sc.nextInt();
            		boolean p2 = mb.delete(deleteID);
             		if(p2) {
             			System.out.println(deleteID+" 已删除");
             		}
             		else {
             			System.out.println(deleteID+" 不存在");
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
