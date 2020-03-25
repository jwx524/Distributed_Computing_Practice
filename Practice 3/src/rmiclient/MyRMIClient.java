//package rmiclient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class MyRMIClient {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try {
            String name = "RMIBook";
            String serverIP = "127.0.0.1";  
            int serverPort = 1099;
			Registry registry = LocateRegistry.getRegistry(serverIP, serverPort);
			MyBook mb = (MyBook) registry.lookup(name);
            book temp = new book(1,"First Book");
            mb.add(temp);
            book idResult = mb.queryById(1);
            System.out.println(idResult.toString());
            booklist nameResult = mb.queryByName("First Book");
            System.out.println(nameResult.toString());
            mb.delete(1);
        } catch (Exception e) {
            System.err.println("??? exception:");
            e.printStackTrace();
        }
	}

}
