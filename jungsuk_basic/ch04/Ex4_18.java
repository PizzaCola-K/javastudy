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
			System.out.print("원하는 메뉴(1~3)를 선택하세요.(종료:0)>");
			
			String tmp = scanner.nextLine();
			menu = Integer.parseInt(tmp);
			
			if(menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else if (!(1<=menu && menu <=3)) {
				System.out.println("메뉴를 잘 못 선택하였습니다.(종료는 0)");
				continue;
			}
			System.out.printf("선택하신 메뉴는 %d번 입니다.%n", menu);
		}
		scanner.close();
	}

}
