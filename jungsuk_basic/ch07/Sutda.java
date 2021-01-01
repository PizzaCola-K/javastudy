package ch07;

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {
		for(int i = 0 ; i < cards.length/2; i++) {
			if(i+1==1 || i+1==3 || i+1==8)
				cards[i] = new SutdaCard(i+1,true);
			else
				cards[i] = new SutdaCard(i+1,false);
		}
		for(int i = 0 ; i < cards.length/2; i++) {
			cards[i+10] = new SutdaCard(i+1,false);
		}
	}
	void suffle() {
		SutdaCard tmpCard = null;
		int randIdx;
		for(int i = 0 ; i<cards.length ; i++) {
			randIdx = (int)(Math.random()*cards.length);
			tmpCard = cards[0];
			cards[0] = cards[randIdx];
			cards[randIdx] = tmpCard;
		}
	}
	SutdaCard pick(int index) {
		return cards[index];
	}
	SutdaCard pick() {
		int randIdx = (int)(Math.random()*cards.length);
		return cards[randIdx];
	}
}

class SutdaCard {
	int num;
	boolean isKwang;
	SutdaCard() {
		this(1,true);
	}
	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String toString() {
		return num+(isKwang? "K" : "");
	}
}