package ch07;

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	void buy (Product p) {
		if(this.money < p.price) {
			System.out.println("�ܾ��� �����Ͽ� ������ �� �� �����ϴ�.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p+"��/�� �����ϼ̽��ϴ�.");
	}
}
