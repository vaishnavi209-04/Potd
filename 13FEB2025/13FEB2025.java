//Approach 1-MinHeap-O(n*log(n))
class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> que=new PriorityQueue<>();
        for(int num:nums)//O(n)
        que.add((long) num);//O(log n)
        int count=0;
        while(!que.isEmpty() && que.peek()<k)
        {
            long smallest=que.poll();
            long secondSmallest=que.poll();
            que.add(smallest*2+secondSmallest);
            count++;
        }
        return count;
    }
}