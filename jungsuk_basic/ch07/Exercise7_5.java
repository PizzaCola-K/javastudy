package ch07;

class Exercise7_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTv t = new MyTv();

		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
	}

}
