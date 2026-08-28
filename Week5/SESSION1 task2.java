import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    // Complete the birthday function below.
    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        int currentSum = 0;

        // If the chocolate bar has fewer squares than the required segment length
        if (s.size() < m) {
            return 0;
        }

        // Calculate the sum of the first 'm' elements (initial window)
        for (int i = 0; i < m; i++) {
            currentSum += s.get(i);
        }

        // Check if the initial window matches the birth day
        if (currentSum == d) {
            count++;
        }

        // Slide the window across the rest of the array
        for (int i = m; i < s.size(); i++) {
            // Add the next element entering the window and subtract the element leaving it
            currentSum += s.get(i) - s.get(i - m);
            
            // Check if the new window sum matches the birth day
            if (currentSum == d) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = birthday(s, d, m);

        System.out.println(result);

        bufferedReader.close();
    }
}
