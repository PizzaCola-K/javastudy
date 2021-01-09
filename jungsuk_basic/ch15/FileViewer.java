package ch15;

import java.io.FileInputStream;
import java.io.IOException;

class FileViewer {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        try{
             fis = new FileInputStream(args[0]);
        } catch (Exception e) {
            System.err.println("Error");
            System.exit(-1);
        }

        int data = 0;

        while((data=fis.read())!=-1) {
            char c = (char) data;
            System.out.print(c);
        }
    }
}
