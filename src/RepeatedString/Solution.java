package RepeatedString;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        if (s.length() == 1 && s.equals("a")) {
            return n;
        }

        long countAIns = 0;
        if (s.length() >= n) {
            for (long i = 0; i < n; i++) {
                if (s.toCharArray()[(int) (i)] == 'a') {
                    countAIns++;
                }
            }
            return countAIns;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.toCharArray()[i] == 'a') {
                countAIns++;
            }
        }

        long strLength = s.length();
        long nDividedByStrLength = n / strLength;
        long residueByStrLength = n % strLength;

        countAIns *= nDividedByStrLength;

        if (residueByStrLength == 0) {
            return countAIns;
        }

        for (long i = 0; i < residueByStrLength; i++) {
            if (s.toCharArray()[(int) i] == 'a') {
                countAIns++;
            }
        }

        return countAIns;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        System.out.println(result);
        scanner.close();
    }
}

