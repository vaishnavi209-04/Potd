//Approach 1-Brute Force-O(n*k)
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int count=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=n-k;i++)
        {
            int j=i;
            while(j<n && j-i+1<=k)
            {
              if(blocks.charAt(j)=='W')
              count++;
              j++;
            }
               min=Math.min(min,count);
               count=0;
        }
        return min;
    }
}
//Approach 2-Sliding Window-O(n)
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int w=0;
        int min=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        while(j<n)
        {
            if(blocks.charAt(j)=='W')
            w++;
            if(j-i+1==k)
            {
                min=Math.min(min,w);
                if(blocks.charAt(i)=='W')
                w--;
                i++;
            }
            j++;
        }
        return min;
    }
}