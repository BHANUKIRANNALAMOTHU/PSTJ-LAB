class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // Move left pointer forward if it's already an even number
            if (nums[left] % 2 == 0) {
                left++;
            } 
            // Move right pointer backward if it's already an odd number
            else if (nums[right] % 2 != 0) {
                right--;
            } 
            // Swap if nums[left] is odd and nums[right] is even
            else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        return nums;
    }
}
