package ch04;

import java.util.Scanner;

public class Ex4_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0, answer = 0;
		
		answer = (int)(Math.random()*100)+1;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.print("1�� 100 ������ ������ �Է��ϼ���.>");
			input = scanner.nextInt();
			if (answer < input) {
				System.out.println("�� ���� ������ �ٽ� �õ��ϼ���.");
			} else if(answer > input) {
				System.out.println("�� ū ������ �ٽ� �õ��ϼ���.");
			}
		} while(input != answer);
		System.out.println("�����Դϴ�.");
		scanner.close();
	}

}
