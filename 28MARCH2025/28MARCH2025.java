//Approach 1:Brute Force with DFS 
//T.C: O(q * m *n)
class Solution {
    int[][] direct={{-1,0},{1,0},{0,1},{0,-1}};
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m=grid.length;
        int n=grid[0].length;
        int q=queries.length;
        int[] res=new int[q];
        for(int i=0;i<q;i++)
        {
           boolean[][] visited=new boolean[m][n];//storing visits
           res[i]=dfs(grid,0,0,queries[i],visited,m,n);//starting from left corner
        }
        return res;
    }
    public int dfs(int[][] grid,int i,int j,int query,boolean[][] vis,int m,int n)
    {   
       if(i<0 || j<0 || i>=m || j>=n || vis[i][j]==true || grid[i][j]>=query)
       return 0;
       int count=1;
       vis[i][j]=true;
       for(int[] dir:direct)
       {
        int i_=i+dir[0];
        int j_=j+dir[1];
        count+=dfs(grid,i_,j_,query,vis,m,n);//neighbour cells
       }       
       return count;
    }
}
//Approach 1:Brute Force with BFS 
//T.C: O(q * m *n)
class Solution {
    int[][] direct={{-1,0},{1,0},{0,1},{0,-1}};
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m=grid.length;
        int n=grid[0].length;
        int q=queries.length;
        int[] res=new int[q];
        for(int i=0;i<q;i++)
        {
           res[i]=bfs(grid,queries[i],m,n);
        }
        return res;
    }
    public int bfs(int[][] grid,int query,int m,int n)
    {
       Queue<int[]> que=new LinkedList<>();//for storing unvisited neighbours
       que.offer(new int[]{0,0});//left corner cell of grid
       boolean[][] visited=new boolean[m][n];//storing visits
       visited[0][0]=true;
       int count=0;
       while(!que.isEmpty())
       {
        int size=que.size();
        while(size-- >0)
        {
            int[] loc=que.poll();
            int i=loc[0];
            int j=loc[1];
            if(grid[i][j]>=query)
            continue;
            count++;
            for(int[] dir:direct)
            {
               int i_=i+dir[0];
               int j_=j+dir[1];
               if(i_>=0 && i_<m && j_>=0 && j_<n && visited[i_][j_]==false && grid[i_][j_]<query)
               {
                que.offer(new int[]{i_,j_});
                visited[i_][j_]=true;
               }
            }
        }
       }
       return count;
    }
}
//Approach 2:Optimal with sorted query and minheap 
//T.C: O(q log q* m *n *log (m*n))
class Solution {
    int[][] direct={{-1,0},{1,0},{0,1},{0,-1}};
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m=grid.length;
        int n=grid[0].length;
        int q=queries.length;
        int[] res=new int[q];
        boolean[][] visited=new boolean[m][n];//storing visits
        int[][] sortedq=new int[q][2];
        for(int i=0;i<q;i++)
        {
            sortedq[i][0]=queries[i];
            sortedq[i][1]=i;
        }
        //sort the query and then count for each query no need for resetting the count 
        //store query and index in an array for result 
        Arrays.sort(sortedq,(a,b)->Integer.compare(a[0],b[0]));//O(qlog q)
        PriorityQueue<int[]> que=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        que.offer(new int[]{grid[0][0],0,0});
        visited[0][0]=true;
        int count=0;
        //worst case pq size =(m*n)
        //push and pop in que =(log size)
        for(int i=0;i<q;i++)
        {
            int query=sortedq[i][0];
            int index=sortedq[i][1];
            while(!que.isEmpty() && que.peek()[0]<query)
            {
                int[] top=que.poll();
                int x=top[1];
                int y=top[2];
                count++;
                for(int[] dir:direct)
                {
                    int i_=x+dir[0];
                    int j_=y+dir[1];
                    if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !visited[i_][j_]) 
                    {
                    que.offer(new int[]{grid[i_][j_],i_,j_});
                    visited[i_][j_]=true;
                    }
                }
            }
            res[index]=count;
        }
        return res;
    }
}