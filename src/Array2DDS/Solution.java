package Array2DDS;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {

            }
            sum1 = arr[i][0] + arr[i][1] + arr[i][2]
                    + arr[i + 1][1]
                    + arr[i + 2][0] + arr[i + 2][1] + arr[i + 2][2];
            sum2 = arr[i][1] + arr[i][2] + arr[i][3]
                    + arr[i + 1][2]
                    + arr[i + 2][1] + arr[i + 2][2] + arr[i + 2][3];
            sum3 = arr[i][2] + arr[i][3] + arr[i][4]
                    + arr[i + 1][3]
                    + arr[i + 2][2] + arr[i + 2][3] + arr[i + 2][4];
            sum4 = arr[i][3] + arr[i][4] + arr[i][5]
                    + arr[i + 1][4]
                    + arr[i + 2][3] + arr[i + 2][4] + arr[i + 2][5];
        }


        return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

