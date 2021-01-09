package ch15;

import java.io.File;

class Ex15_16 {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("USAGE : java Ex15_16 DIRECTORY");
            System.exit(0);
        }
        File f = new File(args[0]);

        if(!f.exists() || !f.isDirectory()) {
            System.out.println("Unavailable Directory");
            System.exit(0);
        }

        File[] files = f.listFiles();
        for(File file : files) {
            String fileName = file.getName();
            System.out.println(file.isDirectory() ? "["+fileName+"]":fileName);
        }
    }
}
