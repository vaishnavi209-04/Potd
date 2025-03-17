class Solution {
    public boolean divideArray(int[] nums) {
        int n=nums.length;
        int[] arr=new int[501];
        for(int num:nums)
        {
            arr[num]++;
        }
        for(int num:arr)
        {
            if(num%2!=0)
            return false;
        }
        return true;
    }
}