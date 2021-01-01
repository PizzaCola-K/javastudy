package ch07;

class Outer2 {
	class InstanceInner {
		int iv = 100;
	}
	static class StaticInner {
		int iv = 200;
		static int cv = 300;
	}
	void myMethod() {
		class LocalInner {
			int iv = 400;
		}
	}
}

class Ex7_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer2 oc = new Outer2();
		Outer2.InstanceInner ii = oc.new InstanceInner();
		
		System.out.println("ii.iv : "+ii.iv);
		System.out.println("Outer2.StaticInner.cv : "+Outer2.StaticInner.cv);
		//System.out.println("Outer2.StaticInner.cv : "+Outer2.StaticInner.iv);
		
		Outer2.StaticInner si = new Outer2.StaticInner();
		System.out.println("si.iv : "+si.iv);
	}

}
