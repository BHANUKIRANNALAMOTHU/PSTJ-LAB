import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    public static List<Integer> maxSubarray(List<Integer> arr) {
        // Handle edge case for empty array
        if (arr == null || arr.isEmpty()) {
            return Arrays.asList(0, 0);
        }

        // Initialize variables with the first element
        int maxSubarraySum = arr.get(0);
        int currentSubarraySum = arr.get(0);
        
        int maxSubsequenceSum = arr.get(0);
        int maxElement = arr.get(0);

        // Track if we found any positive number for subsequence logic
        boolean hasPositive = arr.get(0) > 0;
        int positiveSum = hasPositive ? arr.get(0) : 0;

        for (int i = 1; i < arr.size(); i++) {
            int num = arr.get(i);

            // 1. Kadane's Algorithm for Maximum Subarray
            currentSubarraySum = Math.max(num, currentSubarraySum + num);
            maxSubarraySum = Math.max(maxSubarraySum, currentSubarraySum);

            // 2. Logic for Maximum Subsequence
            if (num > 0) {
                positiveSum += num;
                hasPositive = true;
            }
            maxElement = Math.max(maxElement, num);
        }

        // If there are positive numbers, the subsequence sum is the total of all positives.
        // If all numbers are negative, it's the maximum single element.
        if (hasPositive) {
            maxSubsequenceSum = positiveSum;
        } else {
            maxSubsequenceSum = maxElement;
        }

        return Arrays.asList(maxSubarraySum, maxSubsequenceSum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

            List<Integer> result = maxSubarray(arr);

            bufferedWriter.write(
                result.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" "))
                + "\n"
            );
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
