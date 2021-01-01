package ch08;

public class Exercise8_6 {
	static void method(boolean b) {
		try {
			System.out.println(1);
			if(b)System.exit(0);
			System.out.println(2);
		} catch (RuntimeException r) {
			// TODO: handle exception
			System.out.println(3);
			return;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(4);
			return;
		} finally {
			System.out.println(5);
		}
		System.out.println(6);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method(true);
		method(false);
	}

}
