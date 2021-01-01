package ch06;

class PlayingCard {
	int kind; // instance variable
	int num;  // instance variable
	
	static int width;  // static variable
	static int height; // static variable
	
	PlayingCard(int k, int n){
		kind = k;
		num = n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlayingCard card = new PlayingCard(1, 1); // local variable
	}

}
