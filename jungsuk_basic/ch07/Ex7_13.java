package ch07;

class Ex7_13 {
	class InstanceInner {}
	static class StaticInner {}
	InstanceInner iv = new InstanceInner();
	static StaticInner cv = new StaticInner();
	
	static void staticMethod() {
		// InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		
		Ex7_13 outer = new Ex7_13();
		InstanceInner obj1 = outer.new InstanceInner();
	}
	
	void instanceMethod() {
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		
		//LocalInner lv = new LocalInner();
	}
	void myMethod() {
		class LocalInner{}
		LocalInner lv = new LocalInner();
	}
}
