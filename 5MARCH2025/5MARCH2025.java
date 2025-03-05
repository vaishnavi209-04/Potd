//Approach 1:Recursion
class Solution {
    public long coloredCells(int n) {
        return solve(n,1,1);  
    }
    public long solve(int n,long count,int curr)
    {
        if(curr==n)
        return count;
        return solve(n,count+4*curr,curr+1);
    }
}
//Approach 2:loop
class Solution {
    public long coloredCells(int n) {
        long count=1;
        for(int i=0;i<n;i++)
        {
            count+=4*i;
        }
        return count;
    }
}
//Approach 3:Maths
class Solution {
    public long coloredCells(int n) {
        return 1+ (long) 2*n*(n-1);
    }
}