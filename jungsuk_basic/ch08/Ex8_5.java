package ch08;

class Ex8_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		} catch (ArithmeticException ae) {
			// TODO: handle exception
			ae.printStackTrace();
			System.out.println("예외메시지 : "+ae.getMessage());
		}
		System.out.println(6);
	}

}
