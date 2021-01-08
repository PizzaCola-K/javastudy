package ch14;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Exercise14_4 {
    public static void main(String[] args) {
        Stream<Integer> die = IntStream.rangeClosed(1,6).boxed();

        /*
        die.map(i->new int[]{i,6-i})
                .forEach(iArr -> System.out.println(Arrays.toString(iArr)));

         */

        die.flatMap(i-> Stream.of(1,2,3,4,5,6).map(i2->new int[]{i,i2}))
                .filter(iArr->iArr[0]+iArr[1]==6)
                .forEach(iArr -> System.out.println(Arrays.toString(iArr)));


    }
}
