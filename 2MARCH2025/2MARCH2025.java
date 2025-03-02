//Approach 1-Two Pointers-O(n1+n2)
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int i=0;
        int j=0;
        List<int[]> res=new ArrayList<>();
        while(i<n1 && j< n2)
        {
            if(nums1[i][0]==nums2[j][0])
            {
              res.add(new int[]{nums1[i][0],nums1[i][1]+nums2[j][1]});
              i++;
              j++;
            }
            else if(nums1[i][0]<nums2[j][0])
            {
              res.add(new int[]{nums1[i][0],nums1[i][1]});
              i++;
            }
            else
            {
              res.add(new int[]{nums2[j][0],nums2[j][1]});
              j++;
            }
        }
        while(i<n1)
        {
            res.add(new int[]{nums1[i][0],nums1[i][1]});
            i++;
        }
        while(j<n2)
        {
            res.add(new int[]{nums2[j][0],nums2[j][1]});
            j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}