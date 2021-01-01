package ch07;

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	void buy (Product p) {
		if(this.money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p+"을/를 구입하셨습니다.");
	}
}
