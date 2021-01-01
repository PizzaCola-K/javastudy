package ch04;

class Exercise4_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int dice1 = 1; dice1 <= 6 ; dice1++) {
			for (int dice2 = 1; dice2 <= 6; dice2++) {
				if(dice1+dice2 == 6) {
					System.out.printf("(%d, %d)%n", dice1,dice2);
				}
			}
		}
		System.out.println();
		for(int dice1 = 1; dice1 <= 6 ; dice1++) {
			int dice2 = 6-dice1;
			if(1<=dice2&&dice2 <= 6)
				System.out.printf("(%d, %d)%n", dice1,dice2);
		}
	}

}
