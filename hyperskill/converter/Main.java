package converter;

import java.util.Scanner;

public class Main {

    public static String makeNumberPattern(int radix) {
        StringBuilder sb = new StringBuilder();
        sb.append("[+-]?");
        if (radix == 1) {
            sb.append("1+");
        } else if (radix <= 10) {
            String numPat = "[0-" + (radix - 1) + "]+";
            sb.append(numPat);
            sb.append("(\\.");
            sb.append(numPat);
            sb.append(")?");
        } else if (radix <= 36) {
            String numPat = "[0-9a-" + (char) (radix - 11 + 'a') + "]+";
            sb.append(numPat);
            sb.append("(\\.");
            sb.append(numPat);
            sb.append(")?");
        }
        return sb.toString();
    }

    public static String doubleFractionToString(double d, int radix) {
        StringBuilder sb = new StringBuilder();
        double num = d;
        for (int i = 0; i < 5; i++) {
            num *= radix;
            int frac = (int) num;
            if (frac <= 9) {
                sb.append(frac);
            } else {
                sb.append((char)(frac - 10 + 'a'));
            }
            num -= frac;
        }
        return sb.toString();
    }

    public static double fractionParseDouble(String s, int radix) {
        if (s == null) {
            throw new NullPointerException("Input String is null");
        }
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            throw new NumberFormatException();
        }
        double result = 0;
        double currentRadix = radix;
        for (char c : s.toCharArray()) {
            int val = 0;
            if ('0' <= c && c <= '9') {
                val = c - '0';
            } else if ('a' <= c && c <= 'z') {
                val = c - 'a' + 10;
            } else {
                throw new NumberFormatException();
            }
            result += val / currentRadix;
            currentRadix *= radix;
        }
        return result;
    }

    public static String intToString(int i, int radix) {
        if (radix == 1) {
            int num = i;
            StringBuilder sb = new StringBuilder();
            if (num < 0) {
                sb.append('-');
                num = -num;
            }
            for (int ii = 0; ii < num; ii++) {
                sb.append('1');
            }
            return sb.toString();
        } else {
            return Integer.toString(i, radix);
        }
    }

    public static int parseInt(String s, int radix) {
        if (s == null) {
            throw new NullPointerException("Input String is null");
        }

        if (radix == 1) {
            int result = 0;
            boolean isNeg = false;
            int idx = 0;
            if (s.charAt(0) == '-') {
                isNeg = true;
                idx++;
            } else if (s.charAt(0) == '+') {
                idx++;
            }
            while (idx < s.length()) {
                if (s.charAt(idx) == '1') {
                    result++;
                } else {
                    throw new NumberFormatException();
                }
                idx++;
            }
            if (isNeg) {
                result = - result;
            }
            return result;
        } else {
            return Integer.parseInt(s, radix);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String intPattern = "[+-]?[0-9a-z]+";
        String radixPattern = "\\d+";

        int sourceRadix;
        int targetRadix;
        String sourceRadixStr = scanner.next();
        if (!sourceRadixStr.matches(radixPattern)) {
            System.out.println("error: Source Radix Not a Number");
            System.exit(-1);
        }
        sourceRadix = Integer.parseInt(sourceRadixStr);
        if (sourceRadix < 1 || sourceRadix > Character.MAX_RADIX) {
            System.out.println("error: Source Radix Out of Range");
            System.exit(-1);
        }

        String numberPattern = makeNumberPattern(sourceRadix);
        String sourceNumberStr = scanner.next();
        if (!sourceNumberStr.matches(numberPattern)) {
            System.out.println("error: Source is Not a Number");
            System.exit(-1);
        }


        String targetRadixStr = scanner.next();
        if (!targetRadixStr.matches(radixPattern)) {
            System.out.println("error: Target Radix Not a Number");
            System.exit(-1);
        }
        targetRadix = Integer.parseInt(targetRadixStr);
        if (targetRadix < 1 || targetRadix > Character.MAX_RADIX) {
            System.out.println("error: Target Radix Out of Range");
            System.exit(-1);
        }

        int sourceNumber = 0;
        if (sourceNumberStr.matches(intPattern)) {
            sourceNumber = parseInt(sourceNumberStr, sourceRadix);
            String targetNumberStr = intToString(sourceNumber, targetRadix);
            System.out.println(targetNumberStr);
        } else {
            String[] number = sourceNumberStr.split("\\.");
            String integerStr = number[0];
            String fractionStr = number[1];
            int integer = parseInt(integerStr, sourceRadix);
            double fraction = fractionParseDouble(fractionStr, sourceRadix);
            String targetIntStr = intToString(integer,targetRadix);
            String targetFractionStr = doubleFractionToString(fraction, targetRadix);
            String targetNumberStr = targetIntStr + "." + targetFractionStr;
            System.out.println(targetNumberStr);
        }
    }
}
