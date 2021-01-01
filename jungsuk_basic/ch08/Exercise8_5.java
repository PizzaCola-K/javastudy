package ch08;

class Exercise8_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			method1();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(5);
		}
	}
	static void method1() {
		try {
			method2();
			System.out.println(1);
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println(2);
		} finally {
			System.out.println(3);
		}
		System.out.println(4);
	}
	static void method2() {
		throw new NullPointerException();
	}
}
