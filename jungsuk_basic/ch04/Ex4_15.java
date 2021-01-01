package ch04;

import java.util.Scanner;

class Ex4_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0, answer = 0;
		
		answer = (int)(Math.random()*100)+1;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.print("1과 100 사이의 정수를 입력하세요.>");
			input = scanner.nextInt();
			if (answer < input) {
				System.out.println("더 작은 값으로 다시 시도하세요.");
			} else if(answer > input) {
				System.out.println("더 큰 값으로 다시 시도하세요.");
			}
		} while(input != answer);
		System.out.println("정답입니다.");
		scanner.close();
	}

}
