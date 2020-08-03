package ArraysArrayManipulation;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        //the algorithm is O(m+n), or (10^7)
        long arr[] = new long[n + 2];//adding 2 more elements so it won't overflow
        long largestValue = 0;

        for (int i = 0; i < queries.length; i++) {
            int startIndx = queries[i][0];
            int endIndx = queries[i][1];
            int addValue = queries[i][2];

            //adding the value just in the first index of the given sequence
            arr[startIndx] += addValue;
            //subtracting the value from the right next to the last given index of the element
            arr[endIndx + 1] -= addValue;
        }

        //next I am adding the value prev ind of array to curr index
        //-/+ will determine the difference and calculate the right value of the element
        //Math.max() will give us the final max value of the array
        //loop is starting from 1, remember I am adding the value of the previous element- this is how I am excluding NullPointerException
        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1];
            largestValue = Math.max(arr[i], largestValue);
        }

        return largestValue;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

