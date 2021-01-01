package ch07;

class Ex7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartTv sTv = new SmartTv();
		sTv.channel = 10;
		sTv.channelUp();
		System.out.println(sTv.channel);
		sTv.displayCaption("Hello World!");
		sTv.caption =true;
		sTv.displayCaption("Hello World!");
		
	}

}

class Tv {
	boolean power;
	int channel;
	void power() {power = !power;}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}

class SmartTv extends Tv {
	boolean caption;
	void displayCaption(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
}