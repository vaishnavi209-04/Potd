//Approach 1-Array-O(n^2)
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int[] arr=new int[(n*n)+1];
        for(int[] nums:grid)
        {
            for(int num:nums)
            {
                arr[num]++;
            }
        }
        int repeated=0,missing=0;
        for(int i=1;i<=n*n;i++)
        {
            if(arr[i]==0)
            missing=i;
            if(arr[i]==2)
            repeated=i;
        }
        return new int[]{repeated,missing};
    }
}