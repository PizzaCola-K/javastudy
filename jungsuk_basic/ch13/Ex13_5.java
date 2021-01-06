package ch13;

import javax.swing.*;

class Ex13_5 {
    public static void main(String[] args) {
        ThreadEx5_1 th1 = new ThreadEx5_1();
        th1.start();

        String input = JOptionPane.showInputDialog("Please Input Any Value.");
        System.out.println("Input : "+ input);
    }
}

class ThreadEx5_1 extends Thread {
    public void run() {
        for(int i = 10; i > 0 ; -- i){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}
