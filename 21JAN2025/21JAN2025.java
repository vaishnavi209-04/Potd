//Approach 1:Prefix Sum-O(n)
class Solution {
    public long gridGame(int[][] grid) {
        long firstRowRemainingSum=0;
        int n=grid[0].length;
        for(int i=0;i<n;i++)
        {
            firstRowRemainingSum+=grid[0][i];
        }
        long remainingSecondRowSum=0;
        long minimizedRobot2Sum=Long.MAX_VALUE;
        for(int robot1col=0;robot1col<n;robot1col++)
        {
            firstRowRemainingSum-=grid[0][robot1col];
            long bestOfRobot2=Math.max(firstRowRemainingSum,remainingSecondRowSum);
            minimizedRobot2Sum=Math.min(minimizedRobot2Sum,bestOfRobot2);
            remainingSecondRowSum+=grid[1][robot1col];
        }
        return minimizedRobot2Sum;
    }
}