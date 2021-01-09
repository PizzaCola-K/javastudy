package ch15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

class Ex15_14 {
    public static void main(String[] args) {
        PrintStream ps = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(args[0]);
            ps = new PrintStream(fos);
            System.setOut(ps);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Hello by System.out");
        System.err.println("Hello by System.err");
    }
}
