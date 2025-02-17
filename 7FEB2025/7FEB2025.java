//Approach 1-HashMap + arr- Memory Limit exceed
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n=queries.length;
        int[] ballArr=new int[limit+1];
        Arrays.fill(ballArr,-1);
        Map<Integer,Integer> colCount=new HashMap<>();
        int[] res=new int[n];
        for(int i=0;i<n;i++)
        {
            int ball=queries[i][0];
            int color=queries[i][1];
            if(ballArr[ball]!=-1)
            {
                int prevCol=ballArr[ball];
                colCount.put(prevCol,colCount.get(prevCol)-1);
                if(colCount.get(prevCol)==0)
                colCount.remove(prevCol);
            }
            colCount.put(color,colCount.getOrDefault(color,0)+1);
            ballArr[ball]=color;
            res[i]=colCount.size();
            
        }
        return res;
    }
}
//Approach 2-HashMap + HashMap- O(n)
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n=queries.length;
        Map<Integer,Integer> ballToCol=new HashMap<>();
        Map<Integer,Integer> colCount=new HashMap<>();
        int[] res=new int[n];
        for(int i=0;i<n;i++)
        {
            int ball=queries[i][0];
            int color=queries[i][1];
            if(ballToCol.containsKey(ball))
            {
                int prevCol=ballToCol.get(ball);
                colCount.put(prevCol,colCount.get(prevCol)-1);
                if(colCount.get(prevCol)==0)
                colCount.remove(prevCol);
            }
            colCount.put(color,colCount.getOrDefault(color,0)+1);
            ballToCol.put(ball,color);
            res[i]=colCount.size();
            
        }
        return res;
    }
}