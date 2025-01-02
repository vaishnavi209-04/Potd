class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix=new int[words.length];
        String word=words[0];
        //initialising prefixsum array
        if(isVowel(word.charAt(0))&& isVowel(word.charAt(word.length()-1)))
        prefix[0]=1;
        for(int i=1;i<prefix.length;i++)
        {
            String w=words[i];
            if(isVowel(w.charAt(0))&& isVowel(w.charAt(w.length()-1)))
            prefix[i]=prefix[i-1]+1;
            else//no change
            prefix[i]=prefix[i-1];
        }
        int[] res=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int a=queries[i][0];
            int b=queries[i][1];
            if(a>0)
            res[i]=prefix[b]-prefix[a-1];
            else
            res[i]=prefix[b];
        }
        return res;
    }
    public boolean isVowel(char ch)
    {
        //checking for vowels
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
        return true;
        return false;
    }
}