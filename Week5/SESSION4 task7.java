import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;
        
        // Map to store the last seen index of each character
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already seen, move the left pointer
            // to the right of its previous index (only if it is inside the current window)
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Update or insert the last seen position of the character
            map.put(currentChar, right);

            // Calculate the current window size and update the maximum length found
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
