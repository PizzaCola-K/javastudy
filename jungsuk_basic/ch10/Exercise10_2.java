package ch10;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class Exercise10_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String[] DAY_OF_WEEK_KOR = {"","일","월","화","수","목","금","토"};
		Scanner s = new Scanner(System.in);
		
		System.out.println("날짜를 yyyy/MM/dd의 형태로 입력해주세요.(입력예:2021/01/01)");
		System.out.print(">>");
		
		Date inputDate = null;
		
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		while(s.hasNextLine()) {
			try {
				inputDate = df.parse(s.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다. yyyy/MM/dd 형태로 입력하세요.");
			}
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputDate);
		
		System.out.println("입력하신 날짜는 "+DAY_OF_WEEK_KOR[cal.get(Calendar.DAY_OF_WEEK)]+"요일 입니다.");
		
		s.close();
	}

}
