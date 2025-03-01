//Approach 1:Brute Force-O(n)
class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                nums[i]*=2;
                nums[i+1]=0;    
            }
        }
        int k=0;
        for(int i=0;i<n;i++)
        {
          if(nums[i]!=0)
          {
            nums[k++]=nums[i];
          }
        }
        while(k<n)
        {
            nums[k++]=0;
        }
        return nums;
    }
}
//Approach 2:1 pass-O(n)
class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        int k=0;
        for(int i=0;i<n;i++)
        {
            if(i<n-1 && nums[i]!=0 && nums[i]==nums[i+1])
            {
                nums[i]*=2;
                nums[i+1]=0;    
            }
            if(nums[i]!=0)
            {
                if(i!=k)
                {
                   int temp=nums[i];
                   nums[i]=nums[k];
                   nums[k]=temp;
                }
                k++;
            }
        }
        return nums;
    }
}