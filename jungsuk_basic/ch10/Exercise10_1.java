package ch10;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Exercise10_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		
		cal.set(2019, 11, 1);
		int i = 0;
		do {		
			++i;
			cal.add(Calendar.MONTH,1);
			cal.set(Calendar.DAY_OF_WEEK, 1);
			cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, 2);
			d.setTime(cal.getTimeInMillis());
			
			System.out.println(df.format(d)+"은 "+cal.get(Calendar.DAY_OF_WEEK_IN_MONTH)+"번째 일요일입니다.");
		} while(i < 12);
		
		
	}

}
