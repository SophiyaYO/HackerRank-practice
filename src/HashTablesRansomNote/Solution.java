package HashTablesRansomNote;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> noteWords = new Hashtable<>();
        Map<String, Integer> magazineWords = new Hashtable<>();

        convertArrayToHashTable(magazine, magazineWords);

        convertArrayToHashTable(note, noteWords);

        Set<String> setOfWords = noteWords.keySet();

        for (String keyWord : setOfWords) {
            if (!magazineWords.containsKey(keyWord)) {
                System.out.println("No");
                return;
            }
            if (magazineWords.get(keyWord) < noteWords.get(keyWord)) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

    //key:word, value: how many times is it contained in the array
    private static void convertArrayToHashTable(String[] magazine, Map<String, Integer> magazineWords) {
        for (String w : magazine) {
            if (!magazineWords.containsKey(w)) {
                magazineWords.put(w, 0);
            }
            magazineWords.put(w, magazineWords.get(w) + 1);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}

