//Approach 1-Recursion + Memorisation
//Time complexity-O(n* 2^ (log n^2))
//Space complexity- O(n* 2^ (log n^2))-memorisation+ O(log n^2)-system
class Solution {
    public int punishmentNumber(int n) {
        int punish=0;
        for(int num=1;num<=n;num++)//O(n)
        {
            int sq=num*num;
            String s=Integer.toString(sq);
            int[][] t=new int[s.length()][num+1];//for memorisation
            for(int[] arr:t)
            {
                Arrays.fill(arr,-1);
            }
            if(check(0,0,s,num,t)==true)
            punish+=sq;
        }
        return punish;
    }
    public boolean check(int i,int currSum,String s,int num,int[][] t)
    {
        if(i==s.length())//all iterations checked
        return currSum==num;
        if(currSum>num)//parititon becomes greater than num
        return false;
        if(t[i][currSum]!=-1)//already calculated
        return t[i][currSum]==1;
        boolean possible=false;
        for(int j=i;j<s.length();j++)
        {
            String sub=s.substring(i,j+1);//substring from i to j
            int val=Integer.parseInt(sub);
            possible=possible || check(j+1,currSum+val,s,num,t);
            if(possible==true)
            {
            t[i][currSum]=1;
            return true;
            }
        }
        t[i][currSum]=0;
        return false;
    }
}
//Approach 2-Integer Manipulation
//Time complexity-O(n* 2^ (log n^2))
//Space complexity-O(log n^2)
class Solution {
    public int punishmentNumber(int n) {
        int punish=0;
        for(int num=1;num<=n;num++)
        {
            if(check(num*num,0,num)==true)
            punish+=num*num;
        }
        return punish;
    }
    public boolean check(int sq,int currSum,int num)
    {
        if(sq==0)
        return currSum==num;
        return check(sq/10,currSum+sq%10,num) || check(sq/100,currSum+sq%100,num) || check(sq/1000,currSum+sq%1000,num) || check(sq/10000,currSum+sq%10000,num);
    }
}