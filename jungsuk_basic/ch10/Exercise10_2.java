package ch10;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class Exercise10_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String[] DAY_OF_WEEK_KOR = {"","��","��","ȭ","��","��","��","��"};
		Scanner s = new Scanner(System.in);
		
		System.out.println("��¥�� yyyy/MM/dd�� ���·� �Է����ּ���.(�Է¿�:2021/01/01)");
		System.out.print(">>");
		
		Date inputDate = null;
		
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		while(s.hasNextLine()) {
			try {
				inputDate = df.parse(s.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. yyyy/MM/dd ���·� �Է��ϼ���.");
			}
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputDate);
		
		System.out.println("�Է��Ͻ� ��¥�� "+DAY_OF_WEEK_KOR[cal.get(Calendar.DAY_OF_WEEK)]+"���� �Դϴ�.");
		
		s.close();
	}

}
