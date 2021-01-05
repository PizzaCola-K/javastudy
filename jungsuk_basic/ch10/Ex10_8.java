package ch10;

import java.text.SimpleDateFormat;
import java.util.Date;

class Ex10_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date today = new Date();
		
		SimpleDateFormat[] sdf = new SimpleDateFormat[9];
		
		sdf[0] = new SimpleDateFormat("yyyy-MM-dd");
		sdf[1] = new SimpleDateFormat("''yy년 MMM dd일 E요일");
		sdf[2] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf[3] = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		sdf[4] = new SimpleDateFormat("오늘은 올 해의 D번째 날입니다.");
		sdf[5] = new SimpleDateFormat("오늘은 이 달의 d번째 날입니다.");
		sdf[6] = new SimpleDateFormat("오늘은 올 해의 w번째 주입니다.");
		sdf[7] = new SimpleDateFormat("오늘은 이 달의 W번째 주입니다.");
		sdf[8] = new SimpleDateFormat("오늘은 이 달의 F번째 E요일입니다.");
		
		for(int i = 0 ; i < sdf.length;i++) {
			System.out.println(sdf[i].format(today));
		}
	}

}
