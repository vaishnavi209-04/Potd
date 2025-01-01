//Approach 1(Brute)
class Solution {
    public int maxScore(String s) {
        int result=0;
        int n=s.length();
        for(int i=0;i<=n-2;i++)
        {
            int one=0;
            int zero=0;
           for(int j=0;j<=i;j++)
           {
            if(s.charAt(j)=='0')
            zero++;
           }
           for(int k=i+1;k<=n-1;k++)
           {
            if(s.charAt(k)=='1')
            one++;
           }
           result=Math.max(result,zero+one);
        }
        return result;
    }
}
//Approach 2(Better)
class Solution {
    public int maxScore(String s) {
        int result=0;
        int n=s.length();
        int zero=0;
        int leftone=0;
        int totalone=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            totalone++;
        }
        for(int i=0;i<=n-2;i++)
        {
            if(s.charAt(i)=='1')
            leftone++;
            else
            zero++;
            int rightone=totalone-leftone;
           result=Math.max(result,zero+rightone);
        }
        return result;
    }
}
//Approach 3(Optimal)
class Solution {
    public int maxScore(String s) {
        int result=Integer.MIN_VALUE;
        int n=s.length();
        int zero=0;
        int leftone=0;
        int i=0;
        //we have to find leftzero + rightone 
        //rightone=totalone-leftone
        //here in loop find max leftzero-leftone
        for( i=0;i<=n-2;i++)
        {
            if(s.charAt(i)=='1')
            leftone++;
            else
            zero++;
           result=Math.max(result,zero-leftone);
        }
        //after total iteration leftone becomes total one
        if(s.charAt(i)=='1')
        leftone++;
        return result+leftone;
    }
}