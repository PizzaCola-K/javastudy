package ch12;

import java.util.ArrayList;
import java.util.Iterator;

class Ex12_2 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("자바왕", 1,1));
        list.add(new Student("자바짱", 1,2));
        list.add(new Student("홍길동", 2,1));

        Iterator<Student> it = list.iterator();

        while (it.hasNext()) {
            Student s = it.next();
            System.out.println(s.name);
        }
    }
}
