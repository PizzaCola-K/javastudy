package ch11;

import java.util.*;

class Ex11_17 {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("KimJava", 90);
        map.put("KimJava", 100);
        map.put("LeeJava", 100);
        map.put("KangJava", 80);
        map.put("AnJava", 90);

        Set set = map.entrySet();
        Iterator it = set.iterator();

        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println("Name : "+e.getKey()+", Score : "+e.getValue());
        }
        set = map.keySet();
        System.out.println("Member : "+set);

        Collection values = map.values();

        it = values.iterator();
        int total = 0;

        while (it.hasNext()) {
            int i = (int) it.next();
            total += i;
        }

        System.out.println("total : "+total);
        System.out.println("average : "+(double)total/set.size());
        System.out.println("Max : "+Collections.max(values));
        System.out.println("min : "+Collections.min(values));

    }
}
