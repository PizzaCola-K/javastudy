package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final int[] AGES = {
            6,
            7,
            9,
            10,
            11,
            12,
            13,
            14,
            15,
            16,
            17,
            18,
            24,
            24
    };
    public static void main(String[] args) {
        try {
            String contents = readFileAsString(args[0]);
            System.out.println("The text is:");
            System.out.println(contents);
            System.out.println();
            int characters = contents.replaceAll("\\s", "").length();
            String[] sentenceArray = contents.split("[!?\\.]");
            int sentences = sentenceArray.length;
            String[] trimedSentences = new String[sentences];

            for (int i = 0; i < sentenceArray.length; i++) {
                trimedSentences[i] = sentenceArray[i].trim();
            }

            int words = Arrays.stream(trimedSentences)
                    .map(sentence -> sentence.split("\\s").length)
                    .reduce(0, Integer::sum);

            AtomicInteger syllables = new AtomicInteger();
            AtomicInteger polysyllables = new AtomicInteger();

            Pattern vowels = Pattern.compile("[aeiouy]");
            Pattern doubleVowels = Pattern.compile("[aeiouy][aeiouy]");
            Pattern lastE = Pattern.compile("e\\b");
            Pattern firstY = Pattern.compile("\\by");
            Arrays.stream(trimedSentences)
                    .flatMap(sentence -> Arrays.stream(sentence.split("\\s")))
                    .forEach(word -> {
                        Matcher m0 = vowels.matcher(word.toLowerCase());
                        Matcher m1 = doubleVowels.matcher(word.toLowerCase());
                        Matcher m2 = lastE.matcher(word.toLowerCase());
                        Matcher m3 = firstY.matcher(word.toLowerCase());
                        int count = 0;
                        while (m0.find()) {
                            count++;
                        }
                        while (m1.find()) {
                            count--;
                        }
                        while (m2.find()) {
                            count--;
                        }
                        while (m3.find()) {
                            count--;
                        }

                        if (count == 0) {
                            count++;
                        } else if (count > 2) {
                            polysyllables.getAndIncrement();
                        }

                        syllables.addAndGet(count);
                    });

            double ARIscore = 4.71 * characters / (double) words + 0.5 * words / (double) sentences - 21.43;
            double FKscore = 0.39 * words / (double) sentences + 11.8 * syllables.get() / (double) words - 15.59;
            double SMOGscore = 1.043 * Math.sqrt(polysyllables.get() * 30 / (double) sentences) + 3.1291;
            double CLscore = 0.0588 * characters / (double) words * 100 - 0.296 * sentences / (double) words * 100 - 15.8;

            System.out.printf("Words: %d%n", words);
            System.out.printf("Sentences: %d%n", sentences);
            System.out.printf("Characters: %d%n", characters);
            System.out.printf("Syllables: %d%n", syllables.get());
            System.out.printf("Polysyllables: %d%n", polysyllables.get());
            System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.next();

            int ARIIdx = (int) Math.round(ARIscore) - 1;
            if (ARIIdx < 0) {
                ARIIdx = 0;
            } else if (ARIIdx > 13) {
                ARIIdx = 13;
            }
            int FKIdx = (int) Math.round(FKscore) - 1;
            if (FKIdx < 0) {
                FKIdx = 0;
            } else if (FKIdx > 13) {
                FKIdx = 13;
            }
            int SMOGIdx = (int) Math.round(SMOGscore) - 1;
            if (SMOGIdx < 0) {
                SMOGIdx = 0;
            } else if (SMOGIdx > 13) {
                SMOGIdx = 13;
            }
            int CLIdx = (int) Math.round(CLscore) - 1;
            if (CLIdx < 0) {
                CLIdx = 0;
            } else if (CLIdx > 13) {
                CLIdx = 13;
            }

            System.out.println();
            switch (command) {
                case "ARI":
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).%n", ARIscore, AGES[ARIIdx]);
                    break;
                case "FK":
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).%n", FKscore, AGES[FKIdx]);
                    break;
                case "SMOG":
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).%n", SMOGscore, AGES[SMOGIdx]);
                    break;
                case "CL":
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).%n", CLscore, AGES[CLIdx]);
                    break;
                case "all":
                    System.out.printf("Automated Readability Index: %.2f (about %d year olds).%n", ARIscore, AGES[ARIIdx]);
                    System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d year olds).%n", FKscore, AGES[FKIdx]);
                    System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d year olds).%n", SMOGscore, AGES[SMOGIdx]);
                    System.out.printf("Coleman–Liau index: %.2f (about %d year olds).%n", CLscore, AGES[CLIdx]);
                    break;
            }
            double avgAge = (AGES[ARIIdx] + AGES[FKIdx] + AGES[SMOGIdx] + AGES[CLIdx]) / (double) 4;
            System.out.println();
            System.out.printf("This text should be understood by %.2f year olds.", avgAge);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
