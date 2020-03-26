//package rmiserver;

import java.rmi.RemoteException;


//import def.book;
//import def.booklist;

public class MyBookImpl implements MyBook{
	public boolean add(book b) throws RemoteException {
		int p=0;
		book temp=new book();
		for(int i=0;i<List.List.list.size();i++) {
			temp=List.List.list.get(i);
			if(temp.getId()==(b.getId())) {
				p=1;
				b.setName(temp.getName());
				break;
			}
		}
		if(p==0) {
			List.List.list.add(b);
			System.out.println(b.getId()+":"+b.getName()+" 已添加");
			return true;
		}
		else {
			System.out.println(b.getId()+":"+b.getName()+" 已存在");
			return false;
		}
	}
	public book queryById(int bookId) throws RemoteException {
		book temp=new book();
		for(int i=0;i<List.List.list.size();i++) {
			temp=List.List.list.get(i);
			if(temp.getId()==bookId) {
				System.out.println(bookId+":"+temp.getName()+" 已找到");
				return temp;
			}
		}
		System.out.println(bookId+"未找到");
		return null;
	}
	public booklist queryByName(String name) throws RemoteException {
		book temp=new book();
		booklist templist=new booklist();
		for(int i=0;i<List.List.list.size();i++) {
			temp=List.List.list.get(i);
			if(temp.getName().indexOf(name)!=-1) {
				templist.list.add(temp);
				System.out.println(temp.getId()+":"+temp.getName());
			}
		}
		return templist;
	}
	public boolean delete(int bookId) throws RemoteException {
		book temp=new book();
		for(int i=0;i<List.List.list.size();i++) {
			temp=List.List.list.get(i);
			if(temp.getId()==bookId) {
				List.List.list.remove(i);
				System.out.println(bookId+":"+temp.getName()+" 已删除");
				return true;
			}
		}
		System.out.println(bookId+"不存在");
		return false;
	}
}
