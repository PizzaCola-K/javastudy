package ch07;

public class Ex7_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child c = new Child();
		c.method();
	}

}

class Parant {
	int x = 10;
}

class Child extends Parant{
	int x = 20;
	void method() {
		System.out.println("x="+x);
		System.out.println("this.x="+this.x);
		System.out.println("super.x="+super.x);
	}
}