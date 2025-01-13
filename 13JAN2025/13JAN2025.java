//Approach 1:O(n)
class Solution {
    public int minimumLength(String s) {
        int[] arr=new int[26];
        for(char ch:s.toCharArray())
        {
            arr[ch-'a']++;
        }
        int count=0;
        for(int num:arr)
        {
            if(num!=0)
            {
            if(num%2==0)
            count+=2;
            else
            count+=1;
            }
        }
        return count;
    }
}
//Approach 2:O(n)
class Solution {
    public int minimumLength(String s) {
        int n=s.length();
        int deleted=0;
        int[] arr=new int[26];
        for(char ch:s.toCharArray())
        {
            arr[ch-'a']++;
            if(arr[ch-'a']==3)
            {
                arr[ch-'a']-=2;
                deleted+=2;
            }
        }
        return n-deleted;
    }
}