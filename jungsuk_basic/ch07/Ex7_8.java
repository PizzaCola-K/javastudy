package ch07;

class Ex7_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer b = new Buyer();
		b.buy(new Tv1());
		b.buy(new Computer());
		System.out.println("���� ���� ���� "+b.money+"���� �Դϴ�.");
		System.out.println("���� ���ʽ������� "+b.bonusPoint+"���Դϴ�.");
	}

}
