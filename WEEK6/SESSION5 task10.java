import java.util.ArrayList;

public class NaivePatternSearch {

    /**
     * Searches for all occurrences of 'pat' in 'txt' using the Naive Approach.
     * 
     * @param pat The pattern string to look for
     * @param txt The main text string
     * @return List of starting indices where the pattern is found
     */
    public static ArrayList<Integer> search(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        ArrayList<Integer> resultIndices = new ArrayList<>();

        // Slide the pattern over the text one index at a time
        for (int i = 0; i <= n - m; i++) {
            int j;

            // Check for character-by-character match at current index i
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            // If the inner loop ran completely without breaking, pattern matched
            if (j == m) {
                resultIndices.add(i);
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        String txt = "aabaacaadaabaaba";
        String pat = "aaba";

        ArrayList<Integer> matchIndices = search(pat, txt);

        System.out.println("Pattern found at indices: " + matchIndices);
    }
}
