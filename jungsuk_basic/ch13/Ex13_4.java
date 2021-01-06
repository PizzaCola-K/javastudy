package ch13;

import javax.swing.*;

class Ex13_4 {
    public static void main(String[] args) throws Exception{
        String input = JOptionPane.showInputDialog("Please Input Any Value.");
        System.out.println("Input : "+ input);
        for(int i = 10; i > 0 ; -- i){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
}
