package ch07;
class Outer5{
	static class Inner{
		int iv = 200;
	}
}
class Exercise7_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer5.Inner oi = new Outer5.Inner();
		System.out.println(oi.iv);
	}

}
