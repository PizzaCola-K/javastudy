package ch11;

class Student implements Comparable{
    String name;
    int ban;
    int no;
    int kor, eng, math;

    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    int getTotal() {
        return kor+eng+math;
    }
    float getAverage() {
        return (int)((getTotal()/3f)*10+0.5)/10f;
    }
    public String toString() {
        return name+","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+getAverage();
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof  Student))
            return -1;
        Student s = (Student) o;
        return this.name.compareTo(s.name);
    }
}
