//Approach 1-Brute Force-O(k)
class ProductOfNumbers {
    List<Integer> list;
    int n;
    public ProductOfNumbers() {//O(1)
        list=new ArrayList<>();
        n=0;
    }
    
    public void add(int num) {//O(1)
        list.add(num);
    }
    
    public int getProduct(int k) {//O(k)
        int prod=1;
        int len=list.size();
        for(int i=len-k;i<len;i++)
        {
            prod*=list.get(i);
        }
        return prod;
    }
}
//Approach 2-Optimal Approach -O(1)
class ProductOfNumbers {
    List<Integer> list;//storing cumulative product
    int n;
    public ProductOfNumbers() {//O(1)
        list=new ArrayList<>();
        n=0;
    }
    
    public void add(int num) {//O(1)
        if(num==0)//empty list because last k including 0 will have producct 0 
        {
            list.clear();
            n=0;
        }
        else
        {
            if(list.isEmpty())
            {
                list.add(num);//first element will be the first product
            }
            else
            {
                list.add(list.get(n-1)*num);//cumulative product
            }
            n++;
        }

    }
    
    public int getProduct(int k) {//O(1)
        if(k>n)// it had 0 and we deleted the elements so return 0 
        return 0;
        else if(k==n)// all elements product
        return list.get(n-1);
        else 
        return list.get(n-1)/list.get(n-k-1);

    }
}