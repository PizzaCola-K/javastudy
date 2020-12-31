package ch04;

public class Exercise4_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 12345;
		int sum = 0;
		
		while(num>0) {
			System.out.println("+"+num%10);
			sum += num%10;
			num /= 10;
		}
		
		System.out.println("sum="+sum);
	}

}
