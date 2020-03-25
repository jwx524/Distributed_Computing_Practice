package rmiserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyRMIServer {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try {
			String name = "RMIBook";
			MyBook engine = new MyBookImpl();
			MyBook skeleton = (MyBook) UnicastRemoteObject.exportObject(engine, 0);
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
			registry.rebind(name, skeleton);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
