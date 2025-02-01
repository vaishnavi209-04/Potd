//Approach 1:Backtracking-TLE
//find all possible paths and calculate min cose
class Solution {
    int m,n;
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};//right,left,down,up
    public int minCost(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        return dfs(0,0,grid,visited,0);  
    }
    public int dfs(int i,int j,int[][] grid,boolean[][] visited,int cost)
    {
        if(i==m-1 && j==n-1)//already reached the target cell
        return cost;
        visited[i][j]=true;
        int mincost=Integer.MAX_VALUE;
        for(int index=0;index<4;index++)
        {
            int i_=i+directions[index][0];
            int j_=j+directions[index][1];
            if(i_>=0 && i_<m && j_>=0 && j_<n && visited[i_][j_]!=true)
            {
                int nextcost=cost+((grid[i][j]-1!=index)?1:0);//if grid=1(right) && we are not moving (right)index 0 of directions and same for other 3 directions
                mincost=Math.min(mincost,dfs(i_,j_,grid,visited,nextcost));//calculating for neighbours
            }
        }
        visited[i][j]=false;//mark it not visited again because we are backtracking
        return mincost;
    }
}
//Approach 2:Dijkstra
//find shortest path with min cost
class Solution {
    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};//right,left,down,up
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        PriorityQueue<int[]> que=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));//minheap
        int[][] result=new int[m][n];
        for(int[] num:result)
        {
            Arrays.fill(num,Integer.MAX_VALUE);
        }
        result[0][0]=0;//min distance from source to source is 0 as we start from cell (0,0)
        que.offer(new int[]{0,0,0});//{cost,i,j}
        while(!que.isEmpty())
        {
            int[] curr=que.poll();
            int currcost=curr[0];
            int i=curr[1];
            int j=curr[2];
            if(result[i][j]<currcost)
            continue;
            for(int index=0;index<4;index++)
            {
                int i_=i+directions[index][0];
                int j_=j+directions[index][1];
                if(i_>=0 && j_>=0 && i_<m && j_<n)
                {
                    int newcost=currcost+((grid[i][j]-1!=index)?1:0);
                    if(newcost<result[i_][j_])
                    {
                        result[i_][j_]=newcost;
                        que.offer(new int[]{newcost,i_,j_});
                    }
                }
            }
        }
        return result[m-1][n-1];
    }
}