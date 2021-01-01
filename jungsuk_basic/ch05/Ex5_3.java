package ch05;

class Ex5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score = {79,88,91,33,100,55,95};
		
		int max = score[0];
		int min = score[0];
		
		for (int i = 0; i < score.length; i++) {
			if(score[i]>max) {
				max = score[i];
			} else if(score[i]<min){
				min = score[i];
			}
		}
		System.out.println("ÃÖ´ñ°ª : "+max);
		System.out.println("ÃÖ¼Ú°ª : "+min);
	}

}
