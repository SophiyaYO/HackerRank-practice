package ArraysNewYearChaos;

import java.util.Scanner;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int queueLength = q.length;
        int bribes = 0;
        boolean isBribed;

        //implemented Bubble sort
        for (int i = 0; i < queueLength - 1; i++) {

            isBribed =false;
            for (int j = 0; j < (queueLength - i - 1); j++) {
                if (q[j] > q[j+1]){
                    int temp = q[j];

                    if (((q[j] -1) - j) > 2 || ((q[j] -1) - j) < 0 ){
                        System.out.println("Too chaotic");
                        return;
                    }

                    q[j] = q[j+1];
                    q[j+1] = temp;
                    bribes ++;
                    isBribed = true;
                }
            }
            // if there was no bribing in the inner loop,
            // it'll break the loop and continue to next index
            if (!isBribed) {
                break;
            }

        }

        System.out.println(bribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

