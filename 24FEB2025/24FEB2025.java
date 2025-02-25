//Approach 1:Dfs +Dfs -O(n)
class Solution {
    Map<Integer,List<Integer>> adj=new HashMap<>();
    Map<Integer,Integer> bobmap=new HashMap<>();//stroing node and the time in which it reach that node
    int AliceMax;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n=amount.length;
        AliceMax=Integer.MIN_VALUE;
        for(int[] edge:edges)//making adj list for tree
        {
            int u=edge[0];
            int v=edge[1];
            adj.computeIfAbsent(u,k->new  ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k->new  ArrayList<>()).add(u);
        }
        int time=0;
        boolean[] visited=new boolean[n];
        DfsBob( bob,time,visited);
        Arrays.fill(visited,false);
        int income=0;
        DfsAlice(0,0,visited,income,amount);
        return AliceMax;
    }
    public boolean DfsBob(int curr,int t,boolean[] vis)
    {
        vis[curr]=true;
        bobmap.put(curr,t);
        if(curr==0)//reached target
        return true;
        for(int nghbr:adj.getOrDefault(curr,new ArrayList<>()))
        {
            if(!vis[nghbr])
            {
                if(DfsBob(nghbr,t+1,vis))
                return true;
            }
        }
        bobmap.remove(curr);// we don't reach 0th node from curr so remove and return false and choose another
        return false;
    }
    public void DfsAlice(int curr,int t,boolean[] vis,int income,int[] amount)
    {
        vis[curr]=true;
        if(!bobmap.containsKey(curr) || t<bobmap.get(curr))
        income+=amount[curr];
        else if(t==bobmap.get(curr))
        income+=amount[curr]/2;
        if(adj.getOrDefault(curr,new ArrayList<>()).size()==1 && curr!=0)//curr is a leaf node as it contains only 1 element in list
        {
           AliceMax=Math.max(AliceMax,income);
        }
        for(int nghbr:adj.getOrDefault(curr,new ArrayList<>()))
        {
            if(!vis[nghbr])
            {
                DfsAlice(nghbr,t+1,vis,income,amount);
            }
        }
    }
}
//Approach 2:Dfs +Bfs -O(n)
class Solution {
    Map<Integer,List<Integer>> adj=new HashMap<>();
    Map<Integer,Integer> bobmap=new HashMap<>();//stroing node and the time in which it reach that node
    int AliceMax;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n=amount.length;
        AliceMax=Integer.MIN_VALUE;
        for(int[] edge:edges)//making adj list for tree
        {
            int u=edge[0];
            int v=edge[1];
            adj.computeIfAbsent(u,k->new  ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k->new  ArrayList<>()).add(u);
        }
        int time=0;
        boolean[] visited=new boolean[n];
        DfsBob( bob,time,visited);
        Arrays.fill(visited,false);
        int income=0;
        Queue<int[]> que=new LinkedList<>();
        que.add(new int[]{0,0,0});//node,time,income
        while(!que.isEmpty())
        {
            int[] front=que.poll();
            int curr=front[0];
            int t=front[1];
            int inc=front[2];
            if (!bobmap.containsKey(curr) || bobmap.get(curr) > t) {
                inc += amount[curr];
            } else if (t == bobmap.get(curr)) {
                inc += (amount[curr] / 2);
            }

            if (adj.getOrDefault(curr, new ArrayList<>()).size() == 1 && curr != 0) {
                AliceMax = Math.max(AliceMax, inc);
            }
            for (int ngbr : adj.getOrDefault(curr, new ArrayList<>())) {
                if (!visited[ngbr]) {
                    que.add(new int[]{ngbr, t + 1, inc});
                }
            }

            visited[curr] = true;
        }
        return AliceMax;
    }
    public boolean DfsBob(int curr,int t,boolean[] vis)
    {
        vis[curr]=true;
        bobmap.put(curr,t);
        if(curr==0)//reached target
        return true;
        for(int nghbr:adj.getOrDefault(curr,new ArrayList<>()))
        {
            if(!vis[nghbr])
            {
                if(DfsBob(nghbr,t+1,vis))
                return true;
            }
        }
        bobmap.remove(curr);// we don't reach 0th node from curr so remove and return false and choose another
        return false;
    }
}