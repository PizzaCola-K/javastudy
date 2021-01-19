package readability;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] sentences = input.split("[!\\.?]");
        String[] trimedSentences = new String[sentences.length];

        for (int i = 0; i < sentences.length; i++) {
            trimedSentences[i] = sentences[i].trim();
        }

        int wordCount = Arrays.stream(trimedSentences)
                .map(sentence -> sentence.split("\\s").length)
                .reduce(0, Integer::sum);

        if (wordCount / (double) trimedSentences.length > 10) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
    }
}
