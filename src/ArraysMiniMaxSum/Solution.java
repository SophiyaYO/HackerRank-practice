package ArraysMiniMaxSum;

import java.util.Scanner;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long minSum = Long.MAX_VALUE;
        long maxSum = Long.MIN_VALUE;

        //to prevent integer overflow I am using long for the sums
        //description gives that the input will be of 5 integers, but for
        //future use if you won't know how exactly int will be it is better to use
        //the array length for removing the sum not needed
        for (int sumStep = 0; sumStep < arr.length; sumStep++) {
            long currSum = ((long) arr[0] + (long) arr[1] + (long) arr[2] + (long) arr[3] + (long) arr[4] - (long) arr[arr.length - 1 - sumStep]);
            if (minSum > currSum) {
                minSum = currSum;
            }
            if (maxSum < currSum) {
                maxSum = currSum;
            }
        }

        System.out.println(minSum + " " + maxSum);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}

