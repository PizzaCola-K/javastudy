package ch11;

import java.util.HashMap;
import java.util.Scanner;

class Ex11_16 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("myId", "1234");
        map.put("asdf", "1111");
        map.put("asdf", "1234");

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("input ID and PASSWORD");
            System.out.print("id :");
            String id = s.nextLine().trim();
            System.out.print("password :");
            String password = s.nextLine().trim();
            if(!map.containsKey(id)) {
                System.out.println("id is not available");
                continue;
            }

            if(!(map.get(id)).equals(password)) {
                System.out.println("password is not match");
            } else {
                System.out.println("id and password is match");
                break;
            }
        }
        s.close();
    }
}
