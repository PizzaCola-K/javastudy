package ch09;

class Card {
	String kind;
	int number;
	
	Card() {
		this("SPADE",1);
	}
	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
}
