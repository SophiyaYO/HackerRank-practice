package StringsMakingAnagrams;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        char[] strA = a.toCharArray();
        char[] strB = b.toCharArray();

        Arrays.sort(strA);
        Arrays.sort(strB);

        if (Arrays.equals(strA, strB)){
            return 0;
        }



        int seedValue = 0;
        return 3;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        System.out.println(res);

//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

