package ch04;

class Exercise4_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = (int)(Math.random()*100)+1;
		int input = 0;
		int count = 0;
		java.util.Scanner s = new java.util.Scanner(System.in);
		
		do {
			count++;
			System.out.print("1�� 100 ������ ���� �Է��ϼ��� :");
			input = s.nextInt();
			
			if(!(1<=input&&input<=100)) {
				System.out.println("���� �� �Է�");
				count--;
				continue;
			}
			
			if(answer > input) {
				System.out.println("�� ū ���� �Է��ϼ���.");
			}else if (answer < input) {
				System.out.println("�� ���� ���� �Է��ϼ���.");
			} else {
				System.out.printf("�������ϴ�.%n�õ�Ƚ���� %d���Դϴ�.", count);
				break;
			}
			
		} while(true);
		s.close();
	}

}
