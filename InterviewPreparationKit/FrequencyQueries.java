// https://www.hackerrank.com/challenges/frequency-queries/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> output = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < queries.size(); i++) {
            int queryType = queries.get(i).get(0);
            int data = queries.get(i).get(1);

            if (queryType == 1) {
                if (map.containsKey(data)) {
                    int old_frequency_key = map.get(data);
                    int new_frequency_key = old_frequency_key + 1;
                    map.put(data, new_frequency_key);
                    
                    int old_frequency_value = frequencies.get(old_frequency_key);
                    frequencies.put(old_frequency_key, old_frequency_value - 1);

                    if (frequencies.containsKey(new_frequency_key)) {
                        int new_frequency_value = frequencies.get(new_frequency_key);
                        frequencies.put(new_frequency_key, new_frequency_value + 1);
                    }
                    else {
                        frequencies.put(new_frequency_key, 1);
                    }
                }
                else {
                    map.put(data, 1);
                    if (frequencies.containsKey(1)) {
                        frequencies.put(1, frequencies.get(1) + 1);
                    }
                    else {
                        frequencies.put(1, 1);
                    }
                }
            }
            else if (queryType == 2) {
                if (map.containsKey(data) && map.get(data) > 1) {
                    int old_frequency_key = map.get(data);
                    int new_frequency_key = old_frequency_key - 1;
                    map.put(data, new_frequency_key);

                    int old_frequency_value = frequencies.get(old_frequency_key);
                    frequencies.put(old_frequency_key, old_frequency_value - 1);

                    if (frequencies.containsKey(new_frequency_key)) {
                        frequencies.put(new_frequency_key, 
                            frequencies.get(new_frequency_key) + 1);
                    }
                    else {
                        frequencies.put(new_frequency_key, 1);
                    }

                }
                else if (map.containsKey(data)) {
                    map.remove(data);
                    if (frequencies.containsKey(1)) {
                        frequencies.put(1, frequencies.get(1) - 1);
                    }
                }
                
            }
            else {
                if (frequencies.containsKey(data) && frequencies.get(data) > 0) {
                    output.add(1);
                }
                else {
                    output.add(0);
                }
            }
        }

        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
