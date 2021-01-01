package ch07;

class Ex7_17 {
	Object iv = new Object() {void method(){}};
	static Object cv = new Object() {void method(){}};
	
	void myMethod() {
		Object iv = new Object() {void method(){}};	
	}
}
