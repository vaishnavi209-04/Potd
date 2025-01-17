//Approach 1:
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n=derived.length;
        int[] original=new int[n];
        //case1:start from 0
        original[0]=0;
        for(int i=1;i<n;i++)
        {
            original[i]=original[i-1]^derived[i-1];
        }
        if((original[n-1]^original[0])==derived[n-1])
        return true;
        //case2:start from 1
        original[0]=1;
        for(int i=1;i<n;i++)
        {
            original[i]=original[i-1]^derived[i-1];
        }
        if((original[n-1]^original[0])==derived[n-1])
        return true;
        //if both cases are not possible 
        return false;
    }
}
//Approach 2:
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor=0;
        for(int num:derived)
        {
            xor^=num;
        }
        if(xor==0)//derived is formed by :
        //original={a,b,c,d,e}
        //derived={a^b,b^c,c^d,d^e,e^a}
        //xor of derived will always be 0
        //if it is not 0 then original array is not possible
        return true;
        return false;
    }
}