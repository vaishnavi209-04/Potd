class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum=nums[0];
        int maxSum=nums[0];
        int n=nums.length;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]<nums[i+1])
            sum+=nums[i+1];
            else
            sum=nums[i+1];
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}