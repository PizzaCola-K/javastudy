package ch15;

import java.io.*;
import java.util.Vector;

public class FileMergeTest {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("USAGE: java FileMergeTest MERGE_FILENAME FILENAME1 FILENAME2 ...");
            System.exit(0);
        }
        try {
            Vector v= new Vector();
            for(int i = 1; i < args.length;i++) {
                File f = new File(args[i]);

                v.add(new FileInputStream(args[i]));

            }

            SequenceInputStream input = new SequenceInputStream(v.elements());
            FileOutputStream output = new FileOutputStream(args[0]);

            int data = 0;
            while((data = input.read())!=-1) {
                output.write(data);
            }
            input.close();
            output.close();

        }catch (FileNotFoundException e) {
            System.out.println("no File");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
