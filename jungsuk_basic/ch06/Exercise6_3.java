package ch06;

class Exercise6_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student();
		s.name = "È«±æµ¿";
		s.ban  = 1;
		s.no   = 1;
		s.kor  = 100;
		s.eng  = 60;
		s.math = 76;
		
		System.out.println("ÀÌ¸§:"+s.name);
		System.out.println("ÃÑÁ¡:"+s.getTotal());
		System.out.println("Æò±Õ:"+s.getAverage());
	}

}

class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	Student() {}
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban  = ban ;
		this.no   = no  ; 
		this.kor  = kor ; 
		this.eng  = eng ; 
		this.math = math; 
	}
	String info(){
		int sum=this.kor+this.eng+this.math;
		double avg = (int)(sum*10/3.0+0.5)/10.0;
		return this.name+","+this.ban+","+this.no+","+this.kor+","+this.eng+","+this.math+","+sum+","+avg;
	}
	int getTotal() {
		return this.kor+this.eng+this.math;
	}
	float getAverage() {
		return (int)(this.getTotal()*10/3.0+0.5)/10.0f;
	}
}