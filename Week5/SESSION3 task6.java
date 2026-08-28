import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int alternatingCharacters(String s) {
        int deletions = 0;
        
        // Loop through the string starting from the second character
        for (int i = 1; i < s.length(); i++) {
            // If the current character is the same as the previous one, it must be deleted
            if (s.charAt(i) == s.charAt(i - 1)) {
                deletions++;
            }
        }
        
        return deletions;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
