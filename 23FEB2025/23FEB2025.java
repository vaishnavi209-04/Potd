//Approach 1-Recursion-O(n^2)
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n=preorder.length;
        return solve(0,0,n-1,preorder,postorder);
    }
    public TreeNode solve(int prestart,int poststart,int preend,int[] preorder,int[] postorder)
    {
        if(prestart>preend)
        return null;
        TreeNode root=new TreeNode(preorder[prestart]);//current root
        if(prestart==preend)//only one node is left
        return root;
        int nextnode=preorder[prestart+1];//root of left subtree
        int j=poststart;
        while(postorder[j]!=nextnode)// search next node in postorder
        j++;
        int num=j-poststart+1;//calculate the number of nodes in left subtree
        root.left=solve(prestart+1,poststart,prestart+num,preorder,postorder);
        root.right=solve(prestart+num+1,j+1,preend,preorder,postorder);
        return root;
    }
}
//Approach 2-Recursion-O(n)
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n=preorder.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        map.put(postorder[i],i);
        return solve(0,0,n-1,preorder,postorder,map);
    }
    public TreeNode solve(int prestart,int poststart,int preend,int[] preorder,int[] postorder,Map<Integer,Integer> map)
    {
        if(prestart>preend)
        return null;
        TreeNode root=new TreeNode(preorder[prestart]);//current root
        if(prestart==preend)//only one node is left
        return root;
        int nextnode=preorder[prestart+1];//root of left subtree
        int j=map.get(nextnode);//find next node in postorder
        int num=j-poststart+1;//calculate the number of nodes in left subtree
        root.left=solve(prestart+1,poststart,prestart+num,preorder,postorder,map);
        root.right=solve(prestart+num+1,j+1,preend,preorder,postorder,map);
        return root;
    }
}