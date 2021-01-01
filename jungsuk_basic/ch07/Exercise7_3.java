package ch07;

class Product_Exercise7_3 {
	int price;
	int bonusPoint;
	
	Product_Exercise7_3(int price) {
		this.price = price;
		bonusPoint = (int) (price/10.0);
	}
}

class Tv_Exercise7_3 extends Product {
	Tv_Exercise7_3() {
		// super
		super(100);
	}
	public String toString() {
		return "Tv";
	}
}

class Exercise7_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv_Exercise7_3 tv = new Tv_Exercise7_3();
	}

}
