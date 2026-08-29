import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        if (sLen < pLen) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Fill initial frequency arrays for p and the first window of s
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Slide the window across s
        for (int i = 0; i <= sLen - pLen; i++) {
            // Check if current window matches target frequencies
            if (Arrays.equals(pCount, sCount)) {
                result.add(i);
            }

            // Move the window forward if not at the end
            if (i < sLen - pLen) {
                sCount[s.charAt(i) - 'a']--;               // Remove left character
                sCount[s.charAt(i + pLen) - 'a']++;        // Add right character
            }
        }

        return result;
    }
}
