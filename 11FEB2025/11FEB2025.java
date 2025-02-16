//Approach 1-Brute Force
//Time complexity-O(m*n)
//m=s.length()
//n=part.length()
class Solution {
    public String removeOccurrences(String s, String part) {
        while(true)
        {
            int index=s.indexOf(part);
            if(index==-1)
            break;
            s=s.substring(0,index)+s.substring(index+part.length(),s.length());
        }
        return s;
    }
}
//Approach 2-Stack-O(m*n)
class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st=new Stack<>();
        int m=s.length();
        int n=part.length();
        for(int i=0;i<m;i++)
        {
            st.push(s.charAt(i));
            if(st.size()>=n && check(st,part,n)==true)
            {
                for(int j=0;j<n;j++)
                {
                    st.pop();
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
    public boolean check(Stack<Character> st,String part, int n)
    {
        Stack<Character> temp=new Stack<>();
        temp.addAll(st);
        for(int i=n-1;i>=0;i--)
        {
            if(temp.peek()!=part.charAt(i))
            {
                return false;
            }
            temp.pop();
        }
        return true;
    }
}
//Approach 3-String-O(m*n)
class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder result=new StringBuilder();
        int n=part.length();
        for(char ch:s.toCharArray())
        {
            result.append(ch);
            if(result.length()>=n && result.substring(result.length()-n).equals(part))
            result.delete(result.length()-n,result.length());
        }
        return result.toString();
    }
}