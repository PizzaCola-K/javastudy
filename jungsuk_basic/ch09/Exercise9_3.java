package ch09;

class Exercise9_3 {
	public static int count(String src, String target) {
		int count = 0;
		int pos = 0;
		
		do {
			pos = src.indexOf(target,pos);
			if(pos>0) {
				++count;
				pos += target.length();
			}
		}while(pos>0);
			
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count("12345AB12AB345AB","AB"));
		System.out.println(count("12345","AB"));
	}

}
