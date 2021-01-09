package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

class Ex15_3 {
    public static void main(String[] args) {
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;
        byte[] tmp = new byte[4];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.out.println("input  : "+ Arrays.toString(inSrc));

        try{
            while(input.available() > 0) {
                int len = input.read(tmp);
                output.write(tmp, 0, len);

                outSrc = output.toByteArray();
                printArrays(tmp,outSrc);
            }
        } catch (IOException ioe) {

        }
    }
    static void printArrays(byte[] tmp, byte[] outSrc) {
        System.out.println("tmp    : "+Arrays.toString(tmp));
        System.out.println("output : "+Arrays.toString(outSrc));
    }
}
