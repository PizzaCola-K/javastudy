package ch10;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class Ex10_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "yyyy/MM/dd";
		DateFormat df = new SimpleDateFormat(pattern);
		Scanner s = new Scanner(System.in);
		
		Date inDate = null;
		
		System.out.println("��¥�� "+pattern+"�� ���·� �Է����ּ���.(ex.2021/01/01)");
		
		while (s.hasNextLine()) {
			try {
				inDate = df.parse(s.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("��¥�� "+pattern+"�� ���·� �ٽ� �Է����ּ���.(ex.2021/01/01)");
			}
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(inDate);
		Calendar today = Calendar.getInstance();
		
		long dayDiff = (cal.getTimeInMillis() - today.getTimeInMillis())/(60*60*1000);
		System.out.println("�Է��Ͻ� ��¥�� ����� "+dayDiff+"�ð� ���̰� �ֽ��ϴ�.");
		s.close();
	}

}
