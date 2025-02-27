//Approach 1:Kadane's Algorithm-O(n)
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int currmax=nums[0];
        int max=nums[0];
        int currmin=nums[0];
        int min=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
            currmax=Math.max(nums[i],nums[i]+currmax);
            max=Math.max(max,currmax);//max subarray sum
            currmin=Math.min(nums[i],nums[i]+currmin);
            min=Math.min(min,currmin);//min subarray sum
        }
        return Math.max(Math.abs(max),Math.abs(min));
    }
}