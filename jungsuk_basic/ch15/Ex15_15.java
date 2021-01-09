package ch15;

import java.io.File;
import java.io.IOException;

class Ex15_15 {
    public static void main(String[] args) throws IOException {
        File f = new File(args[0]);
        String fileName = f.getName();

        int pos = fileName.lastIndexOf(".");

        System.out.println(f.getName());
        System.out.println(fileName.substring(0,pos));
        System.out.println(fileName.substring(pos+1));
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
        System.out.println(f.getParent());
        System.out.println();

        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
        System.out.println();

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("sun.boot.class.path"));

    }
}
