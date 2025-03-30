//Approach 1-O(n)
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last=new int[26];
        char[] str=s.toCharArray();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch=str[i];
            if(last[ch- 'a']<=i)//storing last index of a character
            last[ch- 'a']=i;
        }
        List<Integer> res=new ArrayList<>();
        int i=0;
        while(i<n)
        {
            int end=last[str[i]- 'a'];
            int j=i;
            while(j<end)
            {
               end=Math.max(end,last[str[j]- 'a']);
               j++;
            }
            res.add(end-i+1);
            i=j+1;
        }
        return res;
    }
}
//Approach 2-O(n)
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last=new int[26];
        char[] str=s.toCharArray();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char ch=str[i];
            if(last[ch- 'a']<=i)//storing last index of a character
            last[ch- 'a']=i;
        }
        List<Integer> res=new ArrayList<>();
        int i=0;
        int start=0;
        int end=0;
        while(i<n)
        {
            end=Math.max(end,last[str[i]- 'a']);
            if(i==end)
            {
            res.add(end-start+1);
            start=end+1;
            }
            i++;
        }
        return res;
    }
}