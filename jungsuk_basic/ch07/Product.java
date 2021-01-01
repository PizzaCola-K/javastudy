package ch07;

public class Product {
	int price;
	int bonusPoint;
	
	Product(int price){
		this.price = price;
		this.bonusPoint = (int)(price/10.0);
	}

}
