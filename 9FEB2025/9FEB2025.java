//Approach 1-HashMap-Count Bad Pairs-O(n)
class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            nums[i]=nums[i]-i;
        }
        long result=0;
        map.put(nums[0],1);
        for(int j=1;j<n;j++)
        {
            int pairsBefore=j;
            int notBad=map.getOrDefault(nums[j],0);
            int bad=pairsBefore-notBad;
            result+=bad;
            map.put(nums[j],notBad+1);
        }
        return result;
    }
}
//Approach 2-HashMap-Count Good Pairs-O(n)
class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        long result=0;
        for(int j=0;j<n;j++)
        {
            int diff=nums[j]-j;
            int totalBefore=j;
            int good=map.getOrDefault(diff,0);
            result+=totalBefore-good;
            map.put(diff,good+1);
        }
        return result;
    }
}