package ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Ex15_12 {
    public static void main(String[] args) {
        String line = "";
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("OS Encoding : "+ isr.getEncoding());

            do {
                System.out.print("Input String. q for exit.>");
                line = br.readLine();
                System.out.println("ECHO : "+line);
            } while (!line.equalsIgnoreCase("q"));
            br.close();
            System.out.println("Exit");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
