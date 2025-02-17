//Approach 1-HashMap with TreeSet
//Time Complexity-O(log n)
//Space Complexity-O(n)
class NumberContainers {
    Map<Integer,Integer> indToNum;
    Map<Integer,TreeSet<Integer>> numToInd;
    public NumberContainers() {
        indToNum=new HashMap<>();
        numToInd=new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(indToNum.containsKey(index))
        {
            int prevNum=indToNum.get(index);//O(1)
            numToInd.get(prevNum).remove(index);//O(log n)
            if(numToInd.get(prevNum).isEmpty())
            numToInd.remove(prevNum);//O(1)
        }
        indToNum.put(index,number);
        numToInd.putIfAbsent(number,new TreeSet<>());
        numToInd.get(number).add(index);//O(log n)
    }
    
    public int find(int number) {
        if(numToInd.containsKey(number))
        {
            return numToInd.get(number).first();//O(1)
        }
        return -1;
    }
}
//Approach 2-HashMap with MinHeap
//Time Complexity-O(log n+ k*log n)
//Space Complexity-O(n)
class NumberContainers {
    Map<Integer,Integer> indToNum;
    Map<Integer,PriorityQueue<Integer>> numToInd;
    public NumberContainers() {
        indToNum=new HashMap<>();
        numToInd=new HashMap<>();
    }
    
    public void change(int index, int number) {
        indToNum.put(index,number);
        numToInd.putIfAbsent(number,new PriorityQueue<>());
        numToInd.get(number).offer(index);//O(log n)
    }
    
    public int find(int number) {
        if(!numToInd.containsKey(number))
        {
            return -1;//O(1)
        }
        PriorityQueue<Integer> pq=numToInd.get(number);
        while(!pq.isEmpty())//O(k* log n)
        {
            int num=pq.peek();//O(1)
            if(indToNum.get(num)==number)
            return num;
            pq.poll();//O(log n)
        }
        return -1;
    }
}
