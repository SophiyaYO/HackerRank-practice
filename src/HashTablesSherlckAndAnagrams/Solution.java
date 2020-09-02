package HashTablesSherlckAndAnagrams;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        Map<String, Integer> collectSubstrings = new HashMap<>();
        int countAnagrams = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String currSubstr = s.substring(i,j);

                char[] chars = currSubstr.toCharArray();

                Arrays.sort(chars);
                currSubstr = String.valueOf(chars);

                if (collectSubstrings.containsKey(currSubstr)) {
                    int duplicatingVal = collectSubstrings.get(currSubstr);
                    countAnagrams += duplicatingVal;

                    collectSubstrings.put(currSubstr, duplicatingVal + 1);
                } else {
                    collectSubstrings.put(currSubstr, 1);
                }
            }
        }

        return countAnagrams;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}

