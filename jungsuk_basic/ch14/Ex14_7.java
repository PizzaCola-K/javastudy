package ch14;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

class Ex14_7 {
    public static void main(String[] args) {
        Stream<String[]> strArrStream = Stream.of(
          new String[] {"abc","def","jkl"},
          new String[] {"ABC","GHI","JKL"}
        );

        // Stream<Stream<String>> strStreamStream = strArrStream.map(Arrays::stream);

        Stream<String> strStream = strArrStream.flatMap(Arrays::stream);

        strStream.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        String[] lineArr = {
          "Believe or not It is true",
          "Do or do not there is no try"
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +")))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();
    }
}
