package ch07;

class Ex7_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer b = new Buyer();
		b.buy(new Tv1());
		b.buy(new Computer());
		b.buy(new Audio());
		b.summary();
		
	}

}
