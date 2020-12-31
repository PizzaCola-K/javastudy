package ch05;

import java.util.Arrays;

public class Ex5_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numArr = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(numArr));
		
		for(int i = 0; i < 100; i++) {
			int idx = (int)(Math.random()*numArr.length);
			int tmp = numArr[0];
			numArr[0] = numArr[idx];
			numArr[idx] = tmp; 
		}
		
		System.out.println(Arrays.toString(numArr));
	}

}
