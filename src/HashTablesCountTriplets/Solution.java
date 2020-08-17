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
        long total = 0;
        Map<Long, Long> count = new HashMap<>(); // count of ints
        Map<Long, Long> tuplets = new HashMap<>(); // map 2nd -> count of links

        for (int i = 0; i < arr.size(); ++i) {
            //System.out.printf("i=%d\n", i);
            long val = arr.get(i);
            // inc total
            if (val % r == 0 && tuplets.containsKey(val / r)) {
                total += tuplets.get(val / r);
                //System.out.printf("%dx %d -> %d -> %d\n", t.count, t.first, val / r, val);
            }
            // create links/tuplets
            if (tuplets.containsKey(val)) {
                tuplets.put(val, tuplets.get(val) + count.get(val/r));
                //System.out.printf("%dx %d -> %d\n", tuplets.get(val).count, tuplets.get(val).first, val);
            } else if (val % r == 0 && count.containsKey(val / r)) {
                //System.out.printf("%dx %d -> %d\n", count.get(val/r), val/r, val);
                tuplets.put(val, count.get(val / r));
            }

            // inc count
            if (count.containsKey(val))
                count.put(val, count.get(val)+1);
            else
                count.put(val, 1L);
        }

        return total;
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

