class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int i = 0;
        int n = s.length();
        int sign = 1;
        int result = 0;

        // 1. Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check if string is empty after whitespaces
        if (i == n) {
            return 0;
        }

        // 2. Check for sign
        if (s.charAt(i) == '+') {
            sign = 1;
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        // 3. Convert digits and handle overflow
        while (i < n) {
            char ch = s.charAt(i);
            
            // Break at the first non-digit character
            if (ch < '0' || ch > '9') {
                break;
            }

            int digit = ch - '0';

            // 4. Rounding / Overflow Check
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
