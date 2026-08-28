import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }

    private boolean matches(String word, String pattern) {
        // Arrays to store mappings. Initialize with 0 (meaning unmapped).
        int[] pToW = new int[26];
        int[] wToP = new int[26];
        
        for (int i = 0; i < pattern.length(); i++) {
            char pChar = pattern.charAt(i);
            char wChar = word.charAt(i);
            
            int pIdx = pChar - 'a';
            int wIdx = wChar - 'a';
            
            // If pattern character is already mapped, verify it matches the current word character
            if (pToW[pIdx] != 0 && pToW[pIdx] != wChar) {
                return false;
            }
            
            // If word character is already mapped, verify it matches the current pattern character
            if (wToP[wIdx] != 0 && wToP[wIdx] != pChar) {
                return false;
            }
            
            // Establish the bidirectional mapping
            pToW[pIdx] = wChar;
            wToP[wIdx] = pChar;
        }
        
        return true;
    }
}
