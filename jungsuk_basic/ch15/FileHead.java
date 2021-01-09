package ch15;

import java.io.*;

class FileHead {
    public static void main(String[] args) throws FileNotFoundException {
        if(args.length != 2) {
            System.out.println("USAGE: java FileHead 10 FILENAME");
            System.exit(0);
        }
        int lineNumber = 0;
        try{
            lineNumber = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("input the number of output lines");
            System.out.println("USAGE: java FileHead 10 FILENAME");
            System.exit(0);
        }

        File f = new File(args[1]);
        if(!f.exists() || f.isDirectory()) {
            System.out.println(f.getPath()+" is Directory or don't exist");
            System.exit(0);
        }
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        try {
            String line = null;
            for(int i = 1 ; (line = br.readLine()) != null && i <= lineNumber; i++ ) {
                System.out.printf("%2d:%s%n",i,line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
