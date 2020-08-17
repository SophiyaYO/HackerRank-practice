package HashTablesCountTriplets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    private static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> collectDivisible = new HashMap<>();
        long counter = 0;

        //check every list number
        for (long currNumber : arr) {
            //if it is not divisible by r or not equal to 1 go to the next number in the list
            if (currNumber != 1 && currNumber % r != 0) {
                continue;
            }

            //collect all unique numbers and count their repeatability
            if (!collectDivisible.containsKey(currNumber)) {
                collectDivisible.put(currNumber, 1L);
            } else {
                long currValue = collectDivisible.get(currNumber);
                collectDivisible.put(currNumber, currValue + 1);
            }
            //assume currNumber is the third value of the triplets
            //calculate the middle and the lowest value of it
            long middle = currNumber / r;
            long low = middle /r;

            //if collectDivisible contains both middle and low
            //increase the counter by the result of the multiplication of the values of middle and low
            if (collectDivisible.containsKey(middle) && collectDivisible.containsKey(low)) {
                counter += (collectDivisible.get(middle) * collectDivisible.get(low));
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

