package ch03;

public class Exercise3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numOfApples = 123;
		int sizeOfBucket = 10;
		int numOfBucket = numOfApples/sizeOfBucket + (numOfApples%sizeOfBucket>0?1:0);
		
		System.out.println("필요한 바구니의 수:"+numOfBucket);
	}

}
