package ch14;

import java.util.stream.Stream;

class Exercise14_5 {
    public static void main(String[] args) {
        String[] strArr = {"aaa","bb","c","dddd"};
        int sum = Stream.of(strArr).map( String::length )
                .reduce(0,(a,b)->a+b);
        int sum2 = Stream.of(strArr).mapToInt(String::length).sum();
        System.out.println("sum="+sum);
        System.out.println("sum2="+sum2);
    }
}
