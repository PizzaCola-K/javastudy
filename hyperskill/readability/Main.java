package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static final String[] AGES = {
            "5-6",
            "6-7",
            "7-9",
            "9-10",
            "10-11",
            "11-12",
            "12-13",
            "13-14",
            "14-15",
            "15-16",
            "16-17",
            "17-18",
            "18-24",
            "24+",
    };
    public static void main(String[] args) {
        try {
            String contents = readFileAsString(args[0]);
            System.out.println("The text is:");
            System.out.println(contents);
            System.out.println();
            int characterCount = contents.replaceAll("\\s", "").length();
            String[] sentences = contents.split("[!?\\.]");
            int sentencesCount = sentences.length;
            String[] trimedSentences = new String[sentencesCount];

            for (int i = 0; i < sentences.length; i++) {
                trimedSentences[i] = sentences[i].trim();
            }

            int wordCount = Arrays.stream(trimedSentences)
                    .map(sentence -> sentence.split("\\s").length)
                    .reduce(0, Integer::sum);

            double score = 4.71 * characterCount / (double) wordCount + 0.5 * wordCount / (double) sentencesCount - 21.43;

            System.out.printf("Words: %d%n", wordCount);
            System.out.printf("Sentences: %d%n", sentencesCount);
            System.out.printf("Characters: %d%n", characterCount);
            System.out.printf("The score is: %.2f%n", score);

            int ageIdx = (int) (score);
            System.out.printf("This text should be understood by %s year olds.", AGES[ageIdx]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
