class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted=nums.clone();
        Arrays.sort(sorted);
        int left=0;
        int right=nums.length-1;

        //finding first index from left
        while(left<nums.length && nums[left]==sorted[left])
        {
            left++;
        }
        if(left==nums.length) return 0;
        while(right>0 && nums[right]==sorted[right])
        {
            right--;
        }
        return right-left+1;
    }
}