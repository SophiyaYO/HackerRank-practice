package StringsTwoStrings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        char[] firstStrArr = s1.toCharArray();
        char[] secondStrArr = s2.toCharArray();
        Map<Character, Boolean> aLetters = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            aLetters.putIfAbsent(firstStrArr[i], false);
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = secondStrArr[i];
            if (aLetters.containsKey(c)){
                return "YES";
            }
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);

//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}

