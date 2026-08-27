import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int numLayers = Math.min(m, n) / 2;

        for (int layer = 0; layer < numLayers; layer++) {
            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;

            List<Integer> ring = new ArrayList<>();

            // 1. Extract layer elements counter-clockwise
            // Top row: left to right
            for (int col = left; col <= right; col++) {
                ring.add(matrix.get(top).get(col));
            }
            // Right column: top+1 to bottom
            for (int row = top + 1; row <= bottom; row++) {
                ring.add(matrix.get(row).get(right));
            }
            // Bottom row: right-1 down to left
            for (int col = right - 1; col >= left; col--) {
                ring.add(matrix.get(bottom).get(col));
            }
            // Left column: bottom-1 down to top+1
            for (int row = bottom - 1; row > top; row--) {
                ring.add(matrix.get(row).get(left));
            }

            // 2. Compute effective rotation shift
            int L = ring.size();
            int shift = r % L;

            // 3. Write rotated values back into matrix
            int idx = 0;

            // Top row
            for (int col = left; col <= right; col++) {
                matrix.get(top).set(col, ring.get((idx + shift) % L));
                idx++;
            }
            // Right column
            for (int row = top + 1; row <= bottom; row++) {
                matrix.get(row).set(right, ring.get((idx + shift) % L));
                idx++;
            }
            // Bottom row
            for (int col = right - 1; col >= left; col--) {
                matrix.get(bottom).set(col, ring.get((idx + shift) % L));
                idx++;
            }
            // Left column
            for (int row = bottom - 1; row > top; row--) {
                matrix.get(row).set(left, ring.get((idx + shift) % L));
                idx++;
            }
        }

        // 4. Print the resulting matrix
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix.get(i).get(j)).append(j == n - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
