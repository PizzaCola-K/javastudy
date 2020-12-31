package ch04;

public class Exercise4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 15;
		if(10 < x && x < 20)
			System.out.println("1: 10 < x < 20");
		char ch = 'A';
		if(!(ch == ' ' || ch == '	'))
			System.out.println("2: space or tap");
		ch = 'x';
		if(ch == 'x' || ch == 'X')
			System.out.println("3: x or X");
		ch = '4';
		if('0'<= ch && ch <='9')
			System.out.println("4: isDigit");
		ch = 'a';
		if('a'<=ch&&ch<='z' || 'A'<=ch&&ch<='Z')
			System.out.println("5: isAlphabet");
		int year = 100;
		if( year%400 == 0 || (year%4 == 0 && year%100 != 0) )
			System.out.println("6: multiples of 400 or multiples of 4 but not 100");
		boolean powerOn = false;
		if(!powerOn)
			System.out.println("7:Power Off");
		String str = "yes";
		if(str.equals("yes"))
			System.out.println("8:str is \"yes\"");
	}

}
