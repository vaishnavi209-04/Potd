class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] arr=s.toCharArray();//converting string to character array
        int n=arr.length;
        int[] updates=new int[n];//keeping count for each index updation
        for(int[] shift:shifts)
        {
            int start=shift[0];
            int end=shift[1];
            int x=shift[2];
            int update;
            if(x==0)
            update=-1;//shifting backwards
            else
            update=1;//shifting forward
            updates[start]+=update;//array difference technique
            if(end+1<n)
            updates[end+1]-=update;//array difference technique
        }
        for(int i=1;i<n;i++)
        {
           updates[i]+=updates[i-1];//finding cumulative sum
        }
        for(int i=0;i<n;i++)
        {
            updates[i]%=26;//for wrapping forwards and bring negative in range from 0-26
            if(updates[i]<0)
            updates[i]+=26;//for backwards making it positive 
            arr[i]=(char)(((arr[i]-'a'+updates[i])%26)+'a');//shifting 
        }
        return new String(arr);//converting character array to string
    }
}