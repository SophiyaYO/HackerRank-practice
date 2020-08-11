package StringsMakingAnagrams;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        int seedValue = 0;

        String checkedAtB = "";//here concat already checked chars
        Map<Character, Integer> duplicates = new HashMap<>();//collect duplicates in string a

        //iteration over string a
        for (int i = 0; i < aLength; i++) {
            char c = a.charAt(i);

            //1st check if string b contains curr char at all
            if (!b.contains(String.valueOf(c))) {
                //check checked string 'checkedB' does not contain char c
                // if it does not contain c, loop through all c chars in a, and increase seedValue with 1 for each
                if (!checkedAtB.contains(String.valueOf(c))) {
                    int index = a.indexOf(String.valueOf(c));

                    while (index >= 0) {
                        seedValue++;
                        index = a.indexOf(String.valueOf(c), index + 1);
                    }

                    checkedAtB += String.valueOf(c);

                }
                //move to next char in a whatever the reason you are getting in this if statement
                continue;
            }

            //collect all that are in both strings a & b and set the amount of them for value
            if (!duplicates.containsKey(c)) {
                int countDuplicates = 0;
                int index = a.indexOf(String.valueOf(c));
                while (index >= 0) {
                    countDuplicates++;
                    index = a.indexOf(String.valueOf(c), index + 1);
                }

                duplicates.put(c, countDuplicates);

            }

        }

        //iterate through string b
        for (int i = 0; i < bLength; i++) {
            char c = b.charAt(i);

            //check if duplicates contain c at all
            //if true decrease value with 1
            //if not increase seedValue with 1
            if (duplicates.containsKey(c)) {
                int currentVal = duplicates.get(c) - 1;
                duplicates.put(c, currentVal);

            } else {
                seedValue++;
            }
        }

        Iterator<Map.Entry<Character, Integer>> iterator = duplicates.entrySet().iterator();

        //add the absolute value of every duplicate char to the seedValue
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            seedValue += Math.abs(entry.getValue());
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

