package ch07;

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	Product[] cart = new Product[10];
	int i = 0;
	void buy (Product p) {
		if(this.money < p.price) {
			System.out.println("�ܾ��� �����Ͽ� ������ �� �� �����ϴ�.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		cart[i++] = p;
		System.out.println(p+"��/�� �����ϼ̽��ϴ�.");
	}
	void summary() {
		int sum = 0;
		String itemList = "";
		
		for(int i = 0; i < cart.length; i++) {
			if(cart[i]==null ) break;
			sum += cart[i].price;
			itemList += cart[i]+", ";
		}
		System.out.println("�����Ͻ� ��ǰ�� �� �ݾ��� "+sum+"���� �Դϴ�.");
		System.out.println("�����Ͻ� ��ǰ�� "+itemList+"�Դϴ�.");
	}
}
