package ch05;

public class Exercise5_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {
			{5,5,5,5,5},
			{10,10,10,10,10},
			{20,20,20,20,20},
			{30,30,30,30,30},			
		};
		
		int total = 0;
		float average = 0;
		
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			count += arr[i].length;
			for(int j = 0; j < arr[i].length;j++) {
				total += arr[i][j];
			}
		}
		average = (float)total/count;
		
		System.out.println("total="+total);
		System.out.println("average="+average);
	}

}
