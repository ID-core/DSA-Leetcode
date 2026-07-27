class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max_right = 0;
        int maxSum = Integer.MIN_VALUE;

        int min_right = 0;
        int minSum = Integer.MAX_VALUE;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
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
        if (maxSum < 0)
            return maxSum;

        int circularSum = 0;
        circularSum = total - minSum;
        return maxSum > circularSum ? maxSum : circularSum;
    }
}