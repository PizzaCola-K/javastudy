package ch06;

public class Ex6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv t;
		t = new Tv();
		t.channel = 7;
		t.channelDown();
		System.out.println("현재 채널은 "+t.channel+" 입니다.");
	}

}

class Tv{
	String color;
	boolean power;
	int channel;
	
	void power() {power=!power;}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}
