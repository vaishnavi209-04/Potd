//Approach 1:Brute Force: O(m*n+k)
//m=no. of rows in mat
//n=no. of col in mat
//k=no. of blocks in arr which are to be painted
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] row=new int[m];//keeping count of blocks filled in an indexth row
        int[] col=new int[n];//keeping count of blocks filled in an indexth column
        HashMap<Integer,int[]> map=new HashMap<>();//store blocks with their indices {row,column} pair
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                map.put(mat[i][j],new int[] {i,j});
            }
        }
        Arrays.fill(row,n);//each row has n blocks(no. of columns=n)
        Arrays.fill(col,m);//each column has m blocks(no. of rows=m)
        for(int i=0;i<arr.length;i++)
        {
            int[] indices=map.get(arr[i]);
            row[indices[0]]--;//decrease the count of painted blocks in the row one by one
            col[indices[1]]--;//decrease the count of painted blocks in the column one by one
            if(row[indices[0]]==0 || col[indices[1]]==0)//if all blocks are painted in any row or col then return that index till we painted 
            return i;
        }
        return -1;//no col or row is painted fully
    }
}
//Approach 2:Brute Force: O(m*n+k)
//m=no. of rows in mat
//n=no. of col in mat
//k=no. of blocks in arr which are to be painted
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[] row=new int[m];//keeping count of blocks filled in an indexth row
        int[] col=new int[n];//keeping count of blocks filled in an indexth column
        int[] rowIndex=new int[m*n+1];
        int[] colIndex=new int[m*n+1];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int num=mat[i][j];
                rowIndex[num]=i;
                colIndex[num]=j;
            }
        }
        Arrays.fill(row,n);//each row has n blocks(no. of columns=n)
        Arrays.fill(col,m);//each column has m blocks(no. of rows=m)
        for(int i=0;i<arr.length;i++)
        {
            int index=arr[i];
            row[rowIndex[index]]--;//decrease the count of painted blocks in the row one by one
            col[colIndex[index]]--;//decrease the count of painted blocks in the column one by one
            if(row[rowIndex[index]]==0 || col[colIndex[index]]==0)//if all blocks are painted in any row or col then return that index till we painted 
            return i;
        }
        return -1;//no col or row is painted fully
    }
}
//Approach 3:Optimal Solution-O(m*n+k)
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] map=new int[arr.length+1];
        int m=mat.length;
        int n=mat[0].length;
        for(int i=0;i<arr.length;i++)
        {
            map[arr[i]]=i;//storing arr elements with its indices
        }
        int minIndex=Integer.MAX_VALUE;//storing result 
        //checking each row for the index when it will get full
        for(int row=0;row<m;row++)
        {
            int maxIndex=Integer.MIN_VALUE;//storing max index of each row till which it will get painted fully
            for(int col=0;col<n;col++)
            {
               int val=mat[row][col];
               int index=map[val];
               maxIndex=Math.max(maxIndex,index);
            }
            minIndex=Math.min(minIndex,maxIndex);
        }
         //checking each col for the index when it will get full
        for(int col=0;col<n;col++)
        {
            int maxIndex=Integer.MIN_VALUE;//storing max index of each col till which it will get painted fully
            for(int row=0;row<m;row++)
            {
               int val=mat[row][col];
               int index=map[val];
               maxIndex=Math.max(maxIndex,index);
            }
            minIndex=Math.min(minIndex,maxIndex);
        }
        return minIndex;
    }
}