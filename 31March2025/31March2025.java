//Approach 1-O(n log n)
class Solution {
    public long putMarbles(int[] weights, int k) {
        int n=weights.length;
        int[] pairSum=new int[n-1];
        for(int i=0;i<n-1;i++)
        {
            pairSum[i]=weights[i]+weights[i+1];//ignore boundary elements and focus on inclusive pairs
        }
        Arrays.sort(pairSum);//sort to find min and max correctly
        long min=0;
        long max=0;
        for(int i=0;i<k-1;i++)
        {
            min+=pairSum[i];
            max+=pairSum[n-1-i-1];
        }
        return max-min;
    }
}