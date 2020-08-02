package ArraysPlusMinusRation;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        DecimalFormat df = new DecimalFormat("0.000000");
        double ratioMinus = 0;
        double ratioPlus = 0;
        double ratioZeros = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                ratioMinus ++;
            } else if (arr[i] > 0) {
                ratioPlus++;
            } else {
                ratioZeros++;
            }
        }

        ratioMinus /= arr.length;
        ratioPlus /= arr.length;
        ratioZeros /= arr.length;

        System.out.println(df.format(ratioPlus));
        System.out.println(df.format(ratioMinus));
        System.out.println(df.format(ratioZeros));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}

