import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        // Loop through each word to check if it's a substring of another word
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                // A word cannot be a substring of itself
                if (i == j) {
                    continue;
                }
                
                // If words[i] is found inside words[j], save it and move to the next word
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; 
                }
            }
        }
        
        return result;
    }
}
