package rmiclient;

import java.rmi.Remote;
import java.rmi.RemoteException;

import def.book;
import def.booklist;

public interface MyBook extends Remote{
	boolean add(book b) throws RemoteException;
	book queryById(int bookId) throws RemoteException;
	booklist queryByName(String name) throws RemoteException;
	boolean delete(int bookId) throws RemoteException;
}
