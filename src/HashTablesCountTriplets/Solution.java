package HashTablesCountTriplets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long counter = 0;

        for (int i = 0; i <= (arr.size() - 3); i++) {

            if (arr.get(i) != 1 && arr.get(i) % r != 0) {
                continue;
            }
            for (int j = i + 1; j <= (arr.size() - 2); j++) {
                if (arr.get(j) / r != arr.get(i)) {
                    continue;
                }

                for (int k = j + 1; k < arr.size(); k++) {
                    if (arr.get(k) / r != arr.get(j)) {
                        continue;
                    }
                    counter++;
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(ans);

//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

