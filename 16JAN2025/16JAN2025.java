//Approach 1:
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int result=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums1)
        {
            map.put(num,map.getOrDefault(num,0)+n);
        }
        for(int num:nums2)
        {
            map.put(num,map.getOrDefault(num,0)+m);
        }
        for(int num:map.keySet())
        {
            if(map.get(num)%2!=0)//even times will get cancel out
            result^=num;
        }
        return result;
    }
}
//Approach 2:
class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(m%2==0 && n%2==0)
        return 0;
        int xor=0;
        if(n%2!=0)//every element of nums2 will come odd times in pairs 
        {
            for(int num:nums1)
            xor^=num;
        }
        if(m%2!=0)//every element of nums1 will come even times in pairs
        {
            for(int num:nums2)
            xor^=num;
        }
        return xor;
    }
}