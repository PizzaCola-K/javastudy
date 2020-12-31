package ch06;

public class Exercise6_20 {
	static int max(int[] arr) {
		if(arr == null || arr.length == 0) {
			return -999999;
		}
		int result = arr[0];
		for(int i = 0; i<arr.length; i++) {
			if(result < arr[i]) {
				result = arr[i];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("ÃÖ´ñ°ª:"+max(data));
		System.out.println("ÃÖ´ñ°ª:"+max(null));
		System.out.println("ÃÖ´ñ°ª:"+max(new int[] {}));
	}

}
