package ch03;

import java.util.Scanner;

class Ex3_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		char ch;
		
		System.out.printf("���� �ϳ��� �Է��ϼ���.>");
		
		String input = scanner.nextLine();
		ch = input.charAt(0);
		if('0' <= ch && ch <= '9') {
			System.out.printf("�Է��Ͻ� ���ڴ� �����Դϴ�.%n");
		}
		
		if('a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z') {
			System.out.printf("�Է��Ͻ� ���ڴ� �������Դϴ�.%n");
		}
		scanner.close();
	}

}
