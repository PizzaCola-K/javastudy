package ch12;

import java.util.ArrayList;

class Ex12_1 {
    public static void main(String[] args) {
        ArrayList<Product> productList = new ArrayList<Product>();
        ArrayList<Tv>      tvList      = new ArrayList<Tv>();
        /*
         ArrayList<Product>      tvList      = new ArrayList<Tv>();  // Error
         ArrayList<Tv>      tvList      = new ArrayList<Tv>();       // OK
        */

        productList.add(new Tv());
        productList.add(new Audio());

        tvList.add(new Tv());
        tvList.add(new Tv());

        printAll(productList);
        // printAll(tvList); error
    }
    public static void printAll(ArrayList<Product> list) {
        for (Product p : list) {
            System.out.println(p);
        }
    }
}
