import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the number of test cases
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());
        
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            String s = br.readLine();
            if (s == null) break;
            s = s.trim();
            
            out.append(calculateStringSimilarity(s)).append("\n");
        }
        
        // Print all outputs at once for speed
        System.out.print(out);
    }

    private static long calculateStringSimilarity(String s) {
        int n = s.length();
        int[] z = new int[n];
        
        // The entire string matches itself completely
        z[0] = n; 
        
        // Sum variable requires 'long' to prevent integer overflow
        long totalSimilarity = n; 
        
        // [l, r] defines the current rightmost Z-box boundaries
        int l = 0, r = 0;
        
        for (int i = 1; i < n; i++) {
            // If i is within the current Z-box, reuse previously computed data
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            
            // Explicitly match characters to expand the current Z-box
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            
            // Adjust boundaries if the box extends further right
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
            
            totalSimilarity += z[i];
        }
        
        return totalSimilarity;
    }
}
