package ch09;

class Ex9_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person(801108111122L);
		Person p2 = new Person(801108111122L);
		
		if(p1.equals(p2))
			System.out.println("p1�� p2�� ���� ����Դϴ�.");
		else
			System.out.println("p1�� p2�� �ٸ� ����Դϴ�.");
	}

}
