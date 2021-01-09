package ch15;

import java.io.*;

class HexaViewer {
    public static void main(String[] args) throws IOException {
        if(args.length != 1) {
            System.out.println("USAGE: java HexaViewer FILENAME");
            System.exit(0);
        }
        File f = new File(args[0]);
        if(!f.exists() || f.isDirectory()) {
            System.out.println(f.getPath()+" is Directory or don't exist");
            System.exit(0);
        }

        FileInputStream input = new FileInputStream(f);
        PrintStream ps = new PrintStream(System.out);

        int data = 0;
        int i = 0;

        while((data=input.read()) != -1) {
            ps.printf("%02X ",data);
            if(++i%16 == 0) {
                ps.println();
            }
        }
        input.close();
        ps.close();
    }
}
