class Solution {
    public int maxAbsoluteSum(int[] nums) {
        // since for absolute value , ans could be max + number or most -ve number
        int maxSum = 0;
        int minSum = 0;
        int max_right = 0;
        int min_right = 0;
        for (int i = 0; i < nums.length; i++) {
            int opt1 = nums[i];
            int opt2 = nums[i] + max_right;
            max_right = opt1 > opt2 ? opt1 : opt2;
            if (max_right > maxSum) {
                maxSum = max_right;
            }

            opt1 = nums[i];
            opt2 = nums[i] + min_right;
            min_right = opt1 < opt2 ? opt1 : opt2;
            if (min_right < minSum) {
                minSum = min_right;
            }
        }
        return maxSum > Math.abs(minSum) ? maxSum : Math.abs(minSum);
    }
}