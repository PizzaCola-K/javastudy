package ch07;

class Ex7_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buyer b = new Buyer();
		b.buy(new Tv1());
		b.buy(new Computer());
		System.out.println("현재 남은 돈은 "+b.money+"만원 입니다.");
		System.out.println("현재 보너스점수는 "+b.bonusPoint+"점입니다.");
	}

}
