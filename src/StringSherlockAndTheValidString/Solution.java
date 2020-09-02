package StringSherlockAndTheValidString;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        String result = "YES";
        Map<Character, Integer> collection = new HashMap<>();
        if (s.length() == 1 || s.length() == 2) {
            return result;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!collection.containsKey(s.charAt(i))) {
                collection.put(s.charAt(i), 1);
            } else {
                collection.put(s.charAt(i), collection.get(s.charAt(i)) + 1);
            }
        }

        int countToComp = collection.get(s.charAt(0));
        boolean isSubtractedAlready = false;

        if (collection.size() == 1) {
            return result;
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : collection.entrySet()) {
            int diff = Math.abs(countToComp - characterIntegerEntry.getValue());

            if (diff>=1){
                if (!isSubtractedAlready) {
                    isSubtractedAlready = true;
                } else if ( isSubtractedAlready) {
                    return "NO";
                } else {
                    return "NO";
                }
            }

        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

