package def;

public class book {
	int id=-1;
	String name=null;
	public book() {}	
	public book(int i) {
		id=i;
	}
	public book(int i,String n) {
		id=i;
		name=n;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name=n;
	}
}
