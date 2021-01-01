package ch05;

class Ex5_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ball = new int[45];
		
		for(int i = 0; i<ball.length; i++) 
			ball[i]=i+1;
		
		int tmp = 0;
		int j = 0;
		
		for(int i = 0; i<6;i++) {
			j = (int)(Math.random()*ball.length);
			tmp = ball[i];
			ball[i] = ball[j];
			ball[j] = tmp; 
		}
		
		for(int i = 0; i<6; i++) {
			System.out.printf("ball[%d]=%d%n", i, ball[i]);
		}
	}

}
