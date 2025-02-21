//Approach 1-DFS with hashset
 //T.C-O(n)
 //S.C-O(n)
class FindElements {
    Set<Integer> values=new HashSet<>();

    public FindElements(TreeNode root) {
        DFS(root,0);
    }
    public void DFS(TreeNode root,int x)//O(n)
    {
        if(root==null)
        return;
        root.val=x;
        values.add(x);
        DFS(root.left,2*x+1);
        DFS(root.right,2*x+2);
    }
    public boolean find(int target)//O(1) 
    {
        if(values.contains(target))
        return true;
        return false;
    }
}
//Approach 2-BFS with hashset
 //T.C-O(n)
 //S.C-O(n)
class FindElements {
    Set<Integer> values=new HashSet<>();

    public FindElements(TreeNode root) {
        BFS(root,0);
    }
    public void BFS(TreeNode root,int x)//O(n)
    {
        Queue<TreeNode> que=new LinkedList<>();
        root.val=x;
        que.add(root);
        while(!que.isEmpty())
        {
            TreeNode temp=que.poll();
            values.add(temp.val);
            if(temp.left!=null)
            {
                temp.left.val=2*temp.val+1;
                que.add(temp.left);
            }
            if(temp.right!=null)
            {
                temp.right.val=2*temp.val+2;
                que.add(temp.right);
            }
        }
        
    }
    public boolean find(int target)//O(1) 
    {
        if(values.contains(target))
        return true;
        return false;
    }
}