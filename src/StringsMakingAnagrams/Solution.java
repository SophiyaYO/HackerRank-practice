package StringsMakingAnagrams;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        char[] strA = a.toCharArray();
        char[] strB = b.toCharArray();

        int aLength = strA.length;
        int bLength = strB.length;
        int seedValue = 0;

        for (int i = 0; i < aLength; i++) {
            char c = strA[i];

            if (!b.contains(String.valueOf(c))) {
                int index = a.indexOf(String.valueOf(c));
                while (index >= 0) {
                    seedValue++;
                    index = a.indexOf(String.valueOf(c), index + 1);
                }
                continue;
            }
        }

        for (int i = 0; i < bLength; i++) {
            char c = strB[i];

            if (!a.contains(String.valueOf(c))) {
                int index = b.indexOf(String.valueOf(c));
                while (index >= 0) {
                    seedValue++;
                    index = b.indexOf(String.valueOf(c), index + 1);
                }
                continue;
            }
        }

        return seedValue;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        System.out.println(res);

        scanner.close();
    }
}

