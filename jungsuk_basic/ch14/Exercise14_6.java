package ch14;

import java.util.OptionalInt;
import java.util.stream.Stream;

class Exercise14_6 {
    public static void main(String[] args) {
        String[] strArr = {"aaa","bb","c","dddd"};

        int max = Stream.of(strArr).mapToInt(String::length).max().getAsInt();

        System.out.println("max = "+max);
    }
}
