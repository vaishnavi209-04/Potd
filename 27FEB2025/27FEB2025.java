//Approach 1-Dp using recursion-O(n^3)
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(arr[i],i);//storing value and index
        }
        int max=0;
        for(int j=1;j<n;j++)
        {
            for(int k=j+1;k<n;k++)//ensuring j<k
            {
                int length=solve(j,k,arr,map);
                if(length>=3)
                {
                    max=Math.max(max,length);
                }
            }
        }
        return max;
    }
    public int solve(int j,int k,int[] arr,Map<Integer,Integer> map)
    {
        int target=arr[k]-arr[j];//arr[i]+arr[j]=arr[k]
        if(map.containsKey(target) && map.get(target)<j)
        {
            int i=map.get(target);
            return solve(i,j,arr,map) +1 ;// +1 for adding kth element in the sequence 
        }
        return 2;// adding ith and jth element if no other element is there in sequence
    }
}
//Approach 2-Dp using recursion and memorization-O(n^3)
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        int[][] t=new int[n][n];
        for(int[] num:t)
        {
           Arrays.fill(num,-1);
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(arr[i],i);//storing value and index
        }
        int max=0;
        for(int j=1;j<n;j++)
        {
            for(int k=j+1;k<n;k++)//ensuring j<k
            {
                int length=solve(j,k,arr,map,t);
                if(length>=3)
                {
                    max=Math.max(max,length);
                }
            }
        }
        return max;
    }
    public int solve(int j,int k,int[] arr,Map<Integer,Integer> map,int[][] t)
    {
        if(t[j][k]!=-1)
        return t[j][k];
        int target=arr[k]-arr[j];//arr[i]+arr[j]=arr[k]
        if(map.containsKey(target) && map.get(target)<j)
        {
            int i=map.get(target);
            t[j][k]= solve(i,j,arr,map,t) +1;
            return t[j][k];// +1 for adding kth element in the sequence 
        }
        return t[j][k]=2;// adding ith and jth element if no other element is there in sequence
    }
}
//Approach 3-Dp using bottom up-O(n^2)
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        int[][] t=new int[n][n];
        for(int[] num:t)
        {
           Arrays.fill(num,2);
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(arr[i],i);//storing value and index
        }
        int max=0;
        for(int j=1;j<n;j++)
        {
            for(int k=j+1;k<n;k++)//ensuring j<k
            {
                int target=arr[k]-arr[j];//arr[i]+arr[j]=arr[k]
                if(map.containsKey(target) && map.get(target)<j)
                {
                       int i=map.get(target);
                       t[j][k]= t[i][j] +1;
                }
                  max=Math.max(max,t[j][k]);
            }
        }
        return max>=3?max:0;
    }
}