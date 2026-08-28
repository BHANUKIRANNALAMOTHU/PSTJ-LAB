class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // Concatenate s with itself
        String doubled = s + s;
        
        // Take the substring from index 1 to the second-to-last index
        String modified = doubled.substring(1, doubled.length() - 1);
        
        // Check if the original string exists inside the modified version
        return modified.contains(s);
    }
}
