package StringAlternatingCharacters;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int strInitLength = s.length();
        stringBuilder.append(s.charAt(0));

        for (int i = 1; i < strInitLength; i++) {
            if (stringBuilder.charAt(stringBuilder.length()-1) != s.charAt(i)) {
                stringBuilder.append(s.charAt(i));
            }
        }

        int deletions = Math.abs(strInitLength - stringBuilder.length());

        return deletions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}

