package objectrepository;

public class Generics <Coffee, RedWine>{
	String name;
	Coffee empid;
	RedWine department;
	
	void display(){
		System.out.println(this.name);
		System.out.println(this.empid);
		System.out.println(this.department);
	}
	public static void main(String[] args) {
	Generics g = new Generics();
	g.name = "String";
	g.empid ='a';
	g.display();
	}
}
