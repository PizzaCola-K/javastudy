package ch06;

class Exercise6_17 {
	static int[] shuffle(int[] arr) {
		int[] result = new int[arr.length];
		
		for(int i = 0; i < result.length;i++) {
			result[i] = arr[i]; 
		}
		for(int i = 0; i < result.length;i++) {
			int tmp = result[i];
			int idx = (int)(Math.random()*result.length);
			result[i] = result[idx];
			result[idx]= tmp; 
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}

}
