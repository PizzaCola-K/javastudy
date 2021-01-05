package ch12;

import java.util.ArrayList;

class Box<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item) {list.add(item);}
    T get(int i) {return list.get(i);}
    int size() {return list.size();}
    public String toString() {return list.toString();}
}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {

}