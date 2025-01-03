//Approach-1
class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        long[] prefix=new long[n];
        long[] suffix=new long[n];
        suffix[n-1]=nums[n-1];
        prefix[0]=nums[0];
        int count=0;
        for(int i=1;i<n;i++)
        {
            prefix[i]=prefix[i-1]+nums[i];
            suffix[n-i-1]=suffix[n-i]+nums[n-i-1];
        }
        for(int i=0;i<n-1;i++)
        {
            if(prefix[i]>=suffix[i+1])
            count++;
        }
        return count;
    }
}
//Approach-2
class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        long prefix=0;
        long suffix=0;
        int count=0;
        long total=0;
        for(int num:nums)
        total+=num;
        for(int i=0;i<n-1;i++)
        {
            prefix+=nums[i];
            suffix=total-prefix;
            if(prefix>=suffix)
            count++;
        }
        return count;
    }
}
