//Approach 1
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list=new ArrayList<>();
        int[] freq=new int[26];
        for(String s:words2)
        {
            int[] temp=new int[26];
            for(char ch:s.toCharArray())
            {
                temp[ch-'a']++;
                freq[ch-'a']=Math.max(freq[ch-'a'],temp[ch-'a']);
            }
        }
        for(String s:words1)
        {
            int[] temp=new int[26];
            for(char ch:s.toCharArray())
            {
                temp[ch-'a']++;
            }
            if(isSubset(temp,freq))
            list.add(s);
        }
        return list;
    }
    public boolean isSubset(int[] temp,int[] freq)
    {
        for(int i=0;i<26;i++)
        {
            if(temp[i]<freq[i])
            return false;
        }
        return true;
    }
}
