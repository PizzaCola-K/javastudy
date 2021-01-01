package ch02;

class Practice2_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1;
		int y = 2;
		int z = 3;
		
		int tmp = x;
		x = y;
		y = z;
		z = tmp;
		
		System.out.println("x="+x);
		System.out.println("y="+y);
		System.out.println("z="+z);
		
	}

}
