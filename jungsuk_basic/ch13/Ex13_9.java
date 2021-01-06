package ch13;

import javax.swing.*;

class Ex13_9 {
    public static void main(String[] args) throws Exception{
        ThreadEx9_1 th1 = new ThreadEx9_1();
        th1.start();

        String input = JOptionPane.showInputDialog("Please Input Any Values");
        System.out.println("Input : "+ input);
        th1.interrupt();
        System.out.println("isInterrupted() : "+th1.isInterrupted());
    }
}

class ThreadEx9_1 extends Thread {
    @Override
    public void run() {
        int i = 10;
        while (i!=0 && !isInterrupted()) {
            System.out.println(i--);
            for(long x = 0; x < 2500000000L;x++);
        }
        System.out.println("Count End");
    }
}