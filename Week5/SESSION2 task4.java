class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        
        // Variables for standard Kadane (Maximum Subarray)
        int maxGlobal = nums[0];
        int maxCurrent = nums[0];
        
        // Variables for modified Kadane (Minimum Subarray)
        int minGlobal = nums[0];
        int minCurrent = nums[0];
        
        totalSum += nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            totalSum += num;
            
            // Standard Kadane to find the max subarray sum
            maxCurrent = Math.max(num, maxCurrent + num);
            maxGlobal = Math.max(maxGlobal, maxCurrent);
            
            // Modified Kadane to find the min subarray sum
            minCurrent = Math.min(num, minCurrent + num);
            minGlobal = Math.min(minGlobal, minCurrent);
        }
        
        // If all elements are negative, maxGlobal will hold the max negative number.
        // totalSum - minGlobal would equal 0, which is incorrect.
        if (maxGlobal < 0) {
            return maxGlobal;
        }
        
        // Return the larger of the non-wrapped and wrapped subarray sums
        return Math.max(maxGlobal, totalSum - minGlobal);
    }
}
