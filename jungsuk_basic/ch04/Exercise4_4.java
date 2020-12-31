package ch04;

public class Exercise4_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = 1, sign = 1; ; i++, sign = -sign) {
			if(sign == -1) {
				System.out.println(i*sign);
			} else {
				System.out.println("+"+i);
			}
			sum +=i*sign;
			if(sum >= 100) {
				System.out.println("="+sum);
				break;
			}
		}
		
		System.out.println();
		int i = 1, sign = 1;
		sum = 0;
		while(sum < 100) {
			if(sign == -1) {
				System.out.println(i*sign);
			} else {
				System.out.println("+"+i);
			}
			sum += i*sign;
			i++;
			sign = -sign;
		}
		System.out.println("="+sum);
	}

}
