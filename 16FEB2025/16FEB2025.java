//Approach :Backtracking-O(n!)
class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] result=new int[2*n-1];//all numbers are twice except 1 so 2*n -1
        boolean[] used=new boolean[n+1];//for numbers in range 1 to n we have used already
        solve(0,n,used,result);//backtracking function
        return result;
    }
    public boolean solve(int i,int n,boolean[] used,int[] result)
    {
        while(i<result.length && result[i]!=0)//index is in range and the index is filled then increment index
        i++;
        if(i==result.length)//we have reached the end of result array then the array is filled at every index so return
        return true;
        for(int num=n;num>=1;num--)//start from largest number always for lexicographical largest sequence
        {
            if(used[num]==true)//we have already used that number
            continue;
                if(num==1)// if the number is 1
                {
                    result[i]=num;// put that number in index
                    used[num]=true;//mark it used
                    if(solve(i+1,n,used,result)==true)//check for furthur index-explore
                    return true;
                    result[i]=0;//if not available then do undo
                    used[num]=false;
                }
                else 
                {
                    if(num+i<result.length && result[num+i]==0)//the index is available for next repetition 
                    {
                        result[i]=num;// do it 
                        result[num+i]=num;
                        used[num]=true;
                        if(solve(i+1,n,used,result)==true)//explore
                        return true;
                        result[i]=0;//not available then undo
                        result[num+i]=0;
                        used[num]=false;
                    }
                }
            }
            return false;//not getting output from this sequence then return false and check for another sequence
    }
}