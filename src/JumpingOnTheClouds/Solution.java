package JumpingOnTheClouds;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int numberPlusOne;
        int numberPlusTwo ;
        int currJumps = 0;
        int numberClouds = c.length;
        int currIndex ;

        while (numberClouds > 0) {
            currIndex = c.length - numberClouds;

            if (c[currIndex] == 1) {
                numberClouds--;
            } else {
                numberPlusOne = currIndex + 1;
                numberPlusTwo = currIndex + 2;

                if (numberPlusTwo < c.length && c[numberPlusTwo] == 0) {
                    numberClouds--;
                    currJumps++;
                    numberClouds--;
                } else if (numberPlusOne < c.length && c[numberPlusOne] == 0) {
                    currJumps++;
                    numberClouds--;
                } else  {
                    break;
                }
            }

        }


        return currJumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        System.out.println(result);

        scanner.close();
    }
}

