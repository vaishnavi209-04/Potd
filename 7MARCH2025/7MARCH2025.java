//Approach 1-Sieve eratosthenes-O(R log(log R) + (R-L))
class Solution {
    public int[] closestPrimes(int left, int right)//O(R-L)
     {
        boolean[] isPrime=sieve(right);
        List<Integer> list=new ArrayList<>();
        int[] res=new int[]{-1,-1};
        for(int i=left;i<=right;i++)
        {
            if(isPrime[i]==true)
            {
                list.add(i);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++)
        {
            int a=list.get(i);
            int b=list.get(i-1);
            int check=a-b;
            if(check<min)
            {
                min=check;
                res[0]=b;
                res[1]=a;
            }
        }
        return res;
    }
    public boolean[] sieve(int n)//O(R(log(log R)))
    {
        boolean[] isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false;
        for(int i=2;i*i<=n;i++)
        {
           if(isPrime[i]==true)
           {
            for(int j=2;i*j<=n;j++)
            {
                isPrime[i*j]=false;
            }
           }
        }
        return isPrime;
    }
}
//Approach 2-Normal Prime with early return-O(sqrt(R) + (R-L))
class Solution {
    public int[] closestPrimes(int left, int right)//O(R-L)
     {
        List<Integer> list=new ArrayList<>();
        int[] res=new int[]{-1,-1};
        for(int i=left;i<=right;i++)
        {
            if(prime(i)==true)
            {
                if(!list.isEmpty() && i-list.get(list.size()-1)<=2)
                return new int[]{list.get(list.size()-1),i};//early return as min it can be {2,3} or {3,5} or {5,7} or {11,13} or{17,19} etc
                list.add(i);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++)
        {
            int a=list.get(i);
            int b=list.get(i-1);
            int check=a-b;
            if(check<min)
            {
                min=check;
                res[0]=b;
                res[1]=a;
            }
        }
        return res;
    }
    public boolean prime(int n)//O(sqrt(R))
    {
        if(n==1)
        return false;
        if(n==2)
        return true;
        for(int i=2;i*i<=n;i++)
        {
          if(n%i==0)
          return false;
        }
        return true;
    }
}