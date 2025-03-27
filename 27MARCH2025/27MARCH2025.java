//Approach 1:Brute Force
//T.C: O(n)
//S.C: O(n^2)
class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();
        HashMap<Integer,Integer> lmap=new HashMap<>();
        HashMap<Integer,Integer> rmap=new HashMap<>();
        for(int num:nums)
        {
            rmap.put(num,rmap.getOrDefault(num,0)+1);//put all count in right side map
        }
        for(int i=0;i<n;i++)
        {
            int num=nums.get(i);
            lmap.put(num,lmap.getOrDefault(num,0)+1);//increase as partition in left map
            rmap.put(num,rmap.get(num)-1);//decrease the element in left map just now
            int n1=i+1;
            int n2=n-i-1;
            if(lmap.get(num)*2>n1 && rmap.get(num)*2>n2)//instead of writing n1/2 and n2/2 move 2 other side and multiply because * is more optimal than / in runtime
            return i;
        }
        return -1;
    }
}
//Approach 2:Optimal using boyer moore's voting algo
//T.C: O(n)
//S.C: O(1)
class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();
        int maj=-1;
        int count=0;
        for(int num:nums)//find majority element using boyer moore's algo
        {
            if(count==0)
            {
                count=1;
                maj=num;
            }
            else if(num==maj)
            count++;
            else 
            count--;
        }
        count=0;
        for(int num:nums)//find total count of the majority element
        {
            if(num==maj)
            count++;
        }
        int leftCount=0;
        int rightCount=0;
        for(int i=0;i<n;i++)
        {
            int num=nums.get(i);
            if(num==maj)//majority element can only become dominant element so need not check for other elements
            {
                leftCount++;//count in left partition
            }
            rightCount=count-leftCount;//count in right partition
            int n1=i+1;
            int n2=n-i-1;
            if(leftCount *2 >n1 && rightCount*2>n2)
            return i;
        }
        return -1;
    }
}