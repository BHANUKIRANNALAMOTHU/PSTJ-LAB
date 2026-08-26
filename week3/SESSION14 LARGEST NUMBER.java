import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert integer array to String array
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        
        // Custom sort using comparator: compare (b + a) to (a + b)
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        
        // Edge case: after sorting, if the largest number is "0", the result is "0"
        if (strNums[0].equals("0")) {
            return "0";
        }
        
        // Build the concatenated result string
        StringBuilder sb = new StringBuilder();
        for (String str : strNums) {
            sb.append(str);
        }
        
        return sb.toString();
    }
}
