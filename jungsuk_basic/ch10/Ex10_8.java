package ch10;

import java.text.SimpleDateFormat;
import java.util.Date;

class Ex10_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date today = new Date();
		
		SimpleDateFormat[] sdf = new SimpleDateFormat[9];
		
		sdf[0] = new SimpleDateFormat("yyyy-MM-dd");
		sdf[1] = new SimpleDateFormat("''yy�� MMM dd�� E����");
		sdf[2] = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf[3] = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		sdf[4] = new SimpleDateFormat("������ �� ���� D��° ���Դϴ�.");
		sdf[5] = new SimpleDateFormat("������ �� ���� d��° ���Դϴ�.");
		sdf[6] = new SimpleDateFormat("������ �� ���� w��° ���Դϴ�.");
		sdf[7] = new SimpleDateFormat("������ �� ���� W��° ���Դϴ�.");
		sdf[8] = new SimpleDateFormat("������ �� ���� F��° E�����Դϴ�.");
		
		for(int i = 0 ; i < sdf.length;i++) {
			System.out.println(sdf[i].format(today));
		}
	}

}
