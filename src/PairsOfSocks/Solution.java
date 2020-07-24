package PairsOfSocks;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;

        Map<Integer, Integer> sockCollection = new Hashtable<>();

        for (int sock : ar) {
            if (sockCollection.isEmpty() || !sockCollection.containsKey(sock)) {
                sockCollection.put(sock, 0);
            }
            sockCollection.put(sock, sockCollection.get(sock) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : sockCollection.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            if (v >= 2) {
                int remain = v % 2;
                int pairsToAdd = v - remain;
                pairs += pairsToAdd / 2;
            }
        }

        return pairs;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
