package ch06;

public class Exercise6_21 {
	static int abs(int value) {
		return value>0?value:-value;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = 5;
		System.out.println(value+"ÀÇ Àý´ñ°ª:"+abs(value));
		value = -10;
		System.out.println(value+"ÀÇ Àý´ñ°ª:"+abs(value));
	}

}
