package ch06;

public class Ex6_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data_1 d1 = new Data_1();
		// Data_2 d2 = new Data_2(); // error
	}

}

class Data_1 {
	int value;
}
class Data_2{
	int value;
	Data_2(int x) {
		value=x;
	}
}