class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n=s1.length();
        int count=0;
        int index1=-1;
        int index2=-1;
        for(int i=0;i<n;i++)
        {
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            if(ch1!=ch2)
            {
            count++;
            if(index1==-1)
            index1=i;
            else if(index2==-1)
            index2=i;
            }
        }
        if(count==0)
        return true;
        else if(count==2)
        {
            if(s1.charAt(index1)==s2.charAt(index2) && s1.charAt(index2)==s2.charAt(index1))
            return true;
            else 
            return false;
        }
        return false;
    }
}