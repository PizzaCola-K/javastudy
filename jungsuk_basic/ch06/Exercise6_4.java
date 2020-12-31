package ch06;

public class Exercise6_4 {
	static double getDistance(int x, int y, int x1, int y1) {
		return Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getDistance(1,1,2,2));
	}

}
