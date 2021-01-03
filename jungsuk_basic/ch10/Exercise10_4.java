package ch10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class Exercise10_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar birthday = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		birthday.set(2000, 0, 1);
		today.set(2016, 0, 29);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("birth day="+df.format(birthday.getTime()));
		System.out.println("today    ="+df.format(today.getTime()));
		
		long diff = (today.getTimeInMillis()-birthday.getTimeInMillis())/(1000*60*60*24);
		System.out.println(diff+" days");
	}

}
