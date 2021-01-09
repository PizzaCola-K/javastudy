package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

class Ex15_2 {
    public static void main(String[] args) {
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;
        byte[] tmp = new byte[10];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        input.read(tmp,0,tmp.length);
        output.write(tmp,5,5);

        outSrc = output.toByteArray();

        System.out.println("input  : "+Arrays.toString(inSrc));
        System.out.println("tmp    : "+Arrays.toString(tmp));
        System.out.println("output : "+Arrays.toString(outSrc));

    }
}
