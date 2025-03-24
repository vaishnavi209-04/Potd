//Approach 1-Sorting-O(n)
class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        int count=0;
        int n=meetings.length;
        int end=0;
        for(int i=0;i<n;i++)
        {
            int start=meetings[i][0];
            if(start>end)
            {
                count+=start-end-1;
            }
            end=Math.max(end,meetings[i][1]);
        }
        if(end<days)
        {
            count+=days-end;
        }
        return count;
    }
}