class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()==k)
        return true;
        if(s.length()<k)
        return false;
        int[] arr=new int[26];
        for(char ch:s.toCharArray())
        {
            arr[ch-'a']++;
        }
        int count=0;
        for(int num:arr)
        {
            if(num%2==1)//count of odd characters
            count++;
        }
        if(count>k)//because every odd count character needs a separate palindrome so n odd characters should atleast have n palindromes 
        return false;
        return true;
    }
}