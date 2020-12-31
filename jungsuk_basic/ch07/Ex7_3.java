package ch07;

public class Ex7_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child2 c = new Child2();
		c.method();
	}

}
class Parant2 {
	int x = 10;
}

class Child2 extends Parant2{
	void method() {
		System.out.println("x="+x);
		System.out.println("this.x="+this.x);
		System.out.println("super.x="+super.x);
	}
}