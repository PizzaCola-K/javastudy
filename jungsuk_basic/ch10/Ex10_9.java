package ch10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Ex10_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("yyyy�� MM�� dd��"); 
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date d= df.parse("2019�� 11�� 23��");
			System.out.println(df2.format(d));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
