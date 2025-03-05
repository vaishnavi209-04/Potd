//Approach 1:Maths
class Solution {
    public boolean checkPowersOfThree(int n) {
        int p=0;
        while(Math.pow(3,p)<=n)
        {
            p++;
        }
        while(n>0)
        {
            if(n>=Math.pow(3,p))
               n-=Math.pow(3,p);
            if(n>=Math.pow(3,p))//we cannot repeat powers in sum
               return false;
            p--;
        }
        return true;
    }
}
//Approach 2:Ternary division
class Solution {
    public boolean checkPowersOfThree(int n) {
        while(n>0)
        {
            if(n%3==2)
            return false;
            n/=3;
        }
        return true;
    }
}