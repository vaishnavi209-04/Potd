//Approach 1-Brute Force
// T.C : O(n * (n+1)!), (n+1)! permutations and n for matching()
// S.C : O(n+1) for result
class Solution {
    public String smallestNumber(String pattern) {
        int n=pattern.length();
        char[] num=new char[n+1];
        for(int i=0;i<=n;i++)
        {
            num[i]=(char)('1'+i);//initialising num with "1234....." upto n+1
        }
        while(!matching(new String(num),pattern))
        {
            nextPermutation(num);
        }
        return new String(num);
    }
    public boolean matching(String num,String pattern)
    {
        for(int i=0;i<pattern.length();i++)
        {
        if((pattern.charAt(i)=='I' && num.charAt(i)>num.charAt(i+1)) ||
        (pattern.charAt(i)=='D' && num.charAt(i)<num.charAt(i+1)))
        return false;
        }
        return true;
    }
    public void nextPermutation(char[] num)
    {
        int i = num.length - 2;
        while (i >= 0 && num[i] >= num[i + 1]) { // [1,4,3,2]
            i--;
        } //i=0 right now
        if (i >= 0) {
            int j = num.length - 1;
            while (num[j] <= num[i]) { 
                j--;
            }
            swap(num, i, j);// swap 1 and 2 -> [2,4,3,1]
        }
        reverse(num, i + 1);//reverse from 1st index -> [2,1,3,4]
    }
    public void swap(char[] num,int i,int j)
    {
        char temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }
    public void reverse(char[] num,int i)
    {
        int j=num.length-1;
        while(i<j)
        {
            swap(num,i++,j--);
        }
    }
}
//Approach 2-Stack-O(n)
class Solution {
    public String smallestNumber(String pattern) {
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int n=pattern.length();
        for(int i=0;i<=n;i++)
        {
            st.push((char)('1'+i));
            if(i==n || pattern.charAt(i)=='I')//if it is 'I' then keep on popping otherwise keep on pushing and then in 'D' it will pop and append in reverse as stack follows LIFO
            {
                while(!st.isEmpty())
                {
                    sb.append(st.pop());
                }
            }
        }
        return sb.toString();
    }
}