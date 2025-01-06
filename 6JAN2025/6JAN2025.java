//Approach 1-Brute Force-O(n^2)
class Solution {
    public int[] minOperations(String boxes) {
        char[] arr=boxes.toCharArray();
        int n=arr.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<n;j++)
            {
                if(arr[j]!='0')
                count+=Math.abs(j-i);
            }
            res[i]=count;
           
        }
        return res;
    }
}
//Approach 2-Optimal-O(n)
class Solution {
    public int[] minOperations(String boxes) {
        int cumValue=0;
        int cumSum=0;
        int n=boxes.length();
        int[] res=new int[n];
        for(int i=0;i<n;i++)
        {
            res[i]=cumSum;
            cumValue+=boxes.charAt(i)=='0'?0:1;
            cumSum+=cumValue;
        }
        cumValue=0;
        cumSum=0;
        for(int i=n-1;i>=0;i--)
        {
            res[i]+=cumSum;
            cumValue+=boxes.charAt(i)=='0'?0:1;
            cumSum+=cumValue;
        }
        return res;
    }
}