package HashTablesFrequencyQueries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> output = new ArrayList<>();
        Map<Integer, Integer> collectNumbers = new HashMap<>();

        for (List<Integer> x : queries) {
//            System.out.println(x.get(0) + " " + x.get(1));

            if (x.get(0) == 1) {
                collectNumbers.putIfAbsent(x.get(1), 0);
                collectNumbers.put(x.get(1), collectNumbers.get(x.get(1)) + 1);
                continue;
            }

            if (x.get(0) == 2) {
                if (collectNumbers.containsKey(x.get(1))) {
                    if (collectNumbers.get(x.get(1)) == 1) {
                        collectNumbers.remove(x.get(1));
                        continue;
                    }
                    collectNumbers.put(x.get(1), collectNumbers.get(x.get(1)) - 1);
                }
                continue;
            }

            if (x.get(0) == 3) {

                //first statement is for time limits.
                //in the description is said that q <= 10^5 and query[i][1] <= 10^9
                // that's why x.get(1) cannot be more then the size of the queries
                if (x.get(1) > queries.size()){
                    output.add(0);
                } else {
                    Set<Integer> l = new HashSet<>(collectNumbers.values());
                    if (l.contains(x.get(1))) {
                        output.add(1);

                    } else {
                        output.add(0);

                    }
                }
            }
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine()
                                .replaceAll("\\s+$", "")
                                .split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        ans.forEach(x -> System.out.println(x));
//        bufferedWriter.write(
//                ans.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

