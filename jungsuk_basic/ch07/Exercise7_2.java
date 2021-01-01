package ch07;

class Exercise7_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SutdaDeck deck = new SutdaDeck();
		
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.suffle();
		
		for(int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i]+",");
		}
		
		System.out.println();
		System.out.println(deck.pick(0));
	}

}
