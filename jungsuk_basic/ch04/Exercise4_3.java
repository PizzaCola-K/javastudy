package ch04;

class Exercise4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= i; j++) {
				sum +=j;
				System.out.print("+"+j);
			}
			System.out.println();
		}
		System.out.println(sum);
	}

}
