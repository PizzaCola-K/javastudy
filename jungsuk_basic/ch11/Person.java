package ch11;

import java.util.Objects;

class Person {
	String name;
	int age;
	Person (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name+":"+age;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) return false;
		Person p = (Person) obj;
		return name.equals(p.name) && age == p.age;
	}
	
	public int hashCode() {
		return Objects.hash(name, age);
	}
}
