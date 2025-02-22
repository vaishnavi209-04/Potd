//Approach 1-DFS-O(n)
class Solution {
    int n;
    public TreeNode recoverFromPreorder(String traversal) {
        n=traversal.length();
        int[] i={0};//for passing reference
        int depth=0;
        return solve(traversal,i,depth);
    }
    public TreeNode solve(String s,int[] i,int depth)
    {
       if(i[0]>=n)
       return null;
       int j=i[0];
       while(j<n && s.charAt(j)=='-')
       {
        j++;
       }
       int dash=j-i[0];
       if(dash!=depth)//humlog aage nikal aaye
       return null;
       i[0]+=dash;//i ko next number pr le aao
       int num=0;
       while(i[0]<n && Character.isDigit(s.charAt(i[0])))
       {
        num= num*10 + (s.charAt(i[0])-'0');//if number is more than 1 digit
        i[0]++;
       }
       TreeNode root=new TreeNode(num);
       root.left=solve(s,i,depth+1);//child has one depth more than parent
       root.right=solve(s,i,depth+1);//child has one depth more than parent
       return root;

    }
}