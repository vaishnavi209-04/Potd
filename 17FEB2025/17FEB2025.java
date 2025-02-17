//Approach 1-Backtracking 
//Time complexity-O(n!)
//Space complexity-O(n)-system stack space   +   O(n*n!)-backtracking
class Solution {
    public int numTilePossibilities(String tiles) {
        int n=tiles.length();
        Set<String> result=new HashSet<>();//total sequences 
        StringBuilder curr=new StringBuilder();//curr sequence
        boolean[] used=new boolean[n];//for index characters used
        solve(tiles,used,result,curr);
        return result.size()-1;//exclude the empty sequence
    }
    public void solve(String tiles,boolean[] used,Set<String> result,StringBuilder curr)
    {
        result.add(curr.toString());
        int n=tiles.length();
        for(int i=0;i<n;i++)
        {
            if(used[i])
            continue;
            used[i]=true;//use
            curr.append(tiles.charAt(i));
            solve(tiles,used,result,curr);//explore
            used[i]=false;//undo
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
//Approach 2-BCharacter count + backtracking
//Time complexity-O(n!)
//Space complexity-O(n)
class Solution {
    int count;
    public int numTilePossibilities(String tiles) {
        int[] arr=new int[26];
         count=0;
        for(char ch:tiles.toCharArray())
        {
            arr[ch-'A']++;
        }
        solve(arr);
        return count-1;//exclude the empty sequence
    }
    public void solve(int[] arr)
    {
        count++;
        for(int i=0;i<26;i++)
        {
            if(arr[i]==0)
            continue;
            arr[i]--;//do
            solve(arr);//explore
            arr[i]++;//undo
        }
    }
}