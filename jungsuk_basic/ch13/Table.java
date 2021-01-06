package ch13;

import java.util.ArrayList;

class Table {
    String[] dishNames = {"donut","donut","burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<String>();

    public synchronized void add(String dish) {
        while(dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name+" is waiting.");
            try {
                wait();
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        dishes.add(dish);
        notify();
        System.out.println("Dishes:"+dishes.toString());
    }
    public void remove(String dishName) {
        synchronized (this) {
            String name = Thread.currentThread().getName();

            while(dishes.size() == 0) {
                System.out.println(name+" is waiting.");
                try{
                    wait();
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }
            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if(dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notify();
                        return;
                    }
                }
                try {
                    System.out.println(name+" is waiting.");
                    wait();
                    Thread.sleep(500);
                }catch (InterruptedException e) {}
            }
        }
    }
    public int dishNum() {return dishNames.length;}
}
