//Approach 1-Using HashMap-O(n*k)
class Solution {
    public int maximumSum(int[] nums) {
        int n=nums.length;
        int max=-1;
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums)
        {
            int sum=0;
            int temp=num;
            while(temp!=0)
            {
                sum+=temp%10;
                temp/=10;
            }
            if(map.containsKey(sum))
            {
                max=Math.max(max,map.get(sum)+num);
                map.put(sum,Math.max(map.get(sum),num));//Update max num for furthur check
            }
            else
            map.put(sum,num);
        }
        return max;
    }
}
//Approach 2-Using Fixed Array-O(n*k)
//Max number can be -1000000000
//999999999-max number with max sum=9*9=81 
class Solution {
    public int maximumSum(int[] nums) {
        int n=nums.length;
        int max=-1;
        int[] arr=new int[82];
        for(int num:nums)
        {
            int sum=0;
            int temp=num;
            while(temp!=0)
            {
                sum+=temp%10;
                temp/=10;
            }
            if(arr[sum]!=0)
            {
                max=Math.max(max,arr[sum]+num);
                arr[sum]=Math.max(arr[sum],num);//Update max num for furthur check
            }
            else
            arr[sum]=num;
        }
        return max;
    }
}