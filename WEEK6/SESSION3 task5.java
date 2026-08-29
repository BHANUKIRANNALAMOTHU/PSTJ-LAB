import java.io.*;

class Result {

    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int marsExploration(String s) {
        int changedCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Indices 0 and 2 of each 3-character group should be 'S', index 1 should be 'O'
            if (i % 3 == 0 || i % 3 == 2) {
                if (s.charAt(i) != 'S') {
                    changedCount++;
                }
            } else {
                if (s.charAt(i) != 'O') {
                    changedCount++;
                }
            }
        }
        
        return changedCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
