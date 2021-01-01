package ch07;

class Outer4 {
	class Inner {
		int iv = 100;
	}
}

class Exercise7_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer4 o = new Outer4();
		Outer4.Inner oi = o.new Inner();
		System.out.println(oi.iv);
		
	}

}
