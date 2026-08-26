class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int count = 0;
        int n = s.length();
        int mid = n / 2;
        
        for (int i = 0; i < mid; i++) {
            // Increment count for first half, decrement for second half
            if (vowels.indexOf(s.charAt(i)) != -1) {
                count++;
            }
            if (vowels.indexOf(s.charAt(i + mid)) != -1) {
                count--;
            }
        }
        
        return count == 0;
    }
}
