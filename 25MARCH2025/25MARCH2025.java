//Approach 1:O(n)-Merge overlapping and count
class Solution {
    public boolean checkValidCuts(int len, int[][] rectangles) {
        int n=rectangles.length;
        int[][] x=new int[n][2];
        int[][] y=new int[n][2];
        for(int i=0;i<n;i++)
        {
            int x1=rectangles[i][0];
            int y1=rectangles[i][1];
            int x2=rectangles[i][2];
            int y2=rectangles[i][3];
            x[i][0]=x1;
            x[i][1]=x2;
            y[i][0]=y1;
            y[i][1]=y2;
        }
        int result1=merge(x);
        if(result1>=3)
        return true;
        int result2=merge(y);
        return (result2>=3);
    }
    public int merge(int[][] arr)
    {
        int n=arr.length;
        List<int[]> list=new ArrayList<>();
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        list.add(new int[]{arr[0][0],arr[0][1]});
        for(int i=1;i<n;i++)
        {
           if(arr[i][0]<list.get(list.size()-1)[1])//overlapping
           {
            list.get(list.size()-1)[1]=Math.max(list.get(list.size()-1)[1],arr[i][1]);
           }
           else
           {
            list.add(new int[]{arr[i][0],arr[i][1]});
           }
        }
        return list.size();
    }
}