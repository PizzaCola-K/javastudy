package ch04;

import java.util.Scanner;

class Ex4_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu = 0;
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			System.out.print("���ϴ� �޴�(1~3)�� �����ϼ���.(����:0)>");
			
			String tmp = scanner.nextLine();
			menu = Integer.parseInt(tmp);
			
			if(menu == 0) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			else if (!(1<=menu && menu <=3)) {
				System.out.println("�޴��� �� �� �����Ͽ����ϴ�.(����� 0)");
				continue;
			}
			System.out.printf("�����Ͻ� �޴��� %d�� �Դϴ�.%n", menu);
		}
		scanner.close();
	}

}
