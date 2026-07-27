class Solution {
    public int maxProduct(int[] nums) {
        int maxproduct = nums[0];
        int n = nums.length;
        int currentproduct = 1;
        for (int i = 0; i < n; i++) {
            currentproduct *= nums[i];
            maxproduct = Math.max(currentproduct, maxproduct);
            if (currentproduct == 0)
                currentproduct = 1;
        }
        currentproduct = 1;
        for (int j = n - 1; j >= 0; j--) {
            currentproduct *= nums[j];
            maxproduct = Math.max(currentproduct, maxproduct);
            if (currentproduct == 0)
                currentproduct = 1;
        }
        return maxproduct;
    }
}