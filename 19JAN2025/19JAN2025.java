//Approach 1-minHeap
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m=heightMap.length;
        int n=heightMap[0].length;
        PriorityQueue<int[]> boundaryCells=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));//minheap with [height,x co-ordinate,y co-ordinate] compared according to height
        boolean[][] visited=new boolean[m][n];
        for(int row=0;row<m;row++)
        {
            boundaryCells.offer(new int[]{heightMap[row][0],row,0});
            visited[row][0]=true;
            boundaryCells.offer(new int[]{heightMap[row][n-1],row,n-1});
            visited[row][n-1]=true;

        }
        for(int col=0;col<n;col++)
        {
            boundaryCells.offer(new int[]{heightMap[0][col],0,col});
            visited[0][col]=true;
            boundaryCells.offer(new int[]{heightMap[m-1][col],m-1,col});
            visited[m-1][col]=true;
        }
        int water=0;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        while(!boundaryCells.isEmpty())
        {
            int[] cell=boundaryCells.poll();
            int height=cell[0];
            int i=cell[1];
            int j=cell[2];
            for(int[] dir:directions)
            {
                int i_=i+dir[0];
                int j_=j+dir[1];
                if(i_>=0 && i_<m && j_>=0 && j_<n && !visited[i_][j_])
                {
                    water+=Math.max(height-heightMap[i_][j_],0);
                    boundaryCells.offer(new int[]{Math.max(height,heightMap[i_][j_]),i_,j_});//validating for further neighbours
                    visited[i_][j_]=true;
                }
            }
        }
        return water;
    }
}