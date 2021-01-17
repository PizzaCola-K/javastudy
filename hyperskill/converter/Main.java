package converter;

import java.util.Scanner;

public class Main {

    public static int parseIntBase1(String source) {
        int result = 0;

        for (char c : source.toCharArray()) {
            result++;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sourceRadixStr = scanner.next();
        String sourceNumberStr = scanner.next();
        String targetRadixStr = scanner.next();
        String pattern = "\\d+";

        if (!sourceRadixStr.matches(pattern) || !sourceNumberStr.matches(pattern)
                || !targetRadixStr.matches(pattern)) {
            System.exit(-1);
        }

        int sourceRadix = Integer.parseInt(sourceRadixStr);
        int sourceNuber = 0;
        int targetRadix = Integer.parseInt(targetRadixStr);
        if (sourceRadix == 1) {
            sourceNuber = parseIntBase1(sourceNumberStr);
        } else if (Character.MIN_RADIX <= sourceRadix && sourceRadix <= Character.MAX_RADIX) {
            sourceNuber = Integer.parseInt(sourceNumberStr, sourceRadix);
        } else {
            System.exit(-1);
        }

        StringBuilder sb = new StringBuilder();
        String targetNumberStr;
        if (targetRadix == 1) {
            for (int i = 0; i < sourceNuber; i++) {
                sb.append('1');
            }
            targetNumberStr = sb.toString();
        } else if (Character.MIN_RADIX <= targetRadix && targetRadix <= Character.MAX_RADIX) {
            targetNumberStr = Integer.toString(sourceNuber, targetRadix);
        } else {
            targetNumberStr = "0";
        }

        System.out.println(targetNumberStr);

    }
}
