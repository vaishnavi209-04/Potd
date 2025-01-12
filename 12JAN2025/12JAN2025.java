//Approach 1:Stack O(n) time complexity with 0(n) space
class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if(n%2!=0)
        return false;
        Stack<Integer> open=new Stack<>();//storing indices with fixed '('
        Stack<Integer> openclose=new Stack<>();//storing unfixed indices
        for(int i=0;i<n;i++)
        {
            if(locked.charAt(i)=='0')
            openclose.push(i);
            else if(s.charAt(i)=='(')
            open.push(i);
            else if(s.charAt(i)==')')
            {
                if(!open.isEmpty())
                open.pop();//fixed balance
                else if(!openclose.isEmpty())
                openclose.pop();// unfixed balance
                else
                return false;//can't be unbalanced
            }
        }
        while(!open.isEmpty() && !openclose.isEmpty() && open.peek()<openclose.peek())
        {//fixed '(' needs a ')' after it so indices check
            open.pop();
            openclose.pop();
        }
        return open.isEmpty();//all are balanced or left '(' fixed 
        //even if open is empty and openclose not empty it will become balanced as it can only have even => even(total)-even(open)=even(openclose)
    }
}

//Approach 2-greedy O(n) with O(1) space complexity
class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if(n%2!=0)
        return false;
        int open=0;
        int close=0;
        //from left to right
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(' || locked.charAt(i)=='0')
            open++;
            else 
            open--;
            if(open<0)
            return false;
        }
        //from right to left
        for(int i=n-1;i>=0;i--)
        {
            if(s.charAt(i)==')' || locked.charAt(i)=='0')
            close++;
            else 
            close--;
            if(close<0)
            return false;
        }
        return true;
    }
}