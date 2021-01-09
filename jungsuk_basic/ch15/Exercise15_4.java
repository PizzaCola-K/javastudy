package ch15;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

class Exercise15_4 {
    static String[] argArr;
    static File curDir;
    static {
        try {
            curDir = new File(System.getProperty("user.dir"));
        }catch (Exception e) {}
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while(true) {
            try {
                String prompt = curDir.getCanonicalPath() + ">>";
                System.out.print(prompt);

                String input = s.nextLine().trim();

                argArr = input.split(" +");

                String command = argArr[0].trim();

                if("".equals(command)) continue;

                command = command.toLowerCase();

                if(command.equals("q")) {
                    System.exit(0);
                } else if (command.equals("cd")) {
                    cd();
                } else {
                    for(int i = 0; i < argArr.length; i++) {
                        System.out.println(argArr[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void cd() {
        if(argArr.length==1) {
            System.out.println(curDir);
            return;
        } else if(argArr.length > 2){
            System.out.println("USAGE : cd directory");
            return;
        }
        String subDir = argArr[1];

        if("..".equals(subDir)) {
            File newDir = curDir.getParentFile();
            if(newDir.exists())
                curDir = newDir;
            else
                System.out.println("Unavailable");
        } else if (".".equals(subDir)) {
            System.out.println(curDir);
        } else {
            File newDir = new File(curDir,subDir);
            if(newDir.exists() && newDir.isDirectory())
                curDir = newDir;
            else {
                System.out.println("Unavailable");
            }
        }
    }
}
