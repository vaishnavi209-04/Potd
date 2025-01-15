//Approach 1:
class Solution {
    public int minimizeXor(int num1, int num2) {
        int res=num1;//suppose if bit count is equal of but num1 and num2 then num1^num1=0(min)
        int required=Integer.bitCount(num2);
        int current=Integer.bitCount(num1);
        int bit=0;
        if(required>current)
        {
            while(required>current)
            {
                if(!isSet(res,bit))//there is not already 1 at the position
                {
                    res=setBit(res,bit);//put 1 there
                    current++;
                }
                bit++;
            }
        }
        else if(current>required)
        {
            while(current>required)
            {
                if(isSet(res,bit))//there is already 1 at the position bit
                {
                    res=unsetBit(res,bit);//remove 1 from that position
                    current--;
                }
                bit++;
            }
        }
        return res;
    }
    public boolean isSet(int num,int index)
    {
        return (num & (1<<index))!=0;
    }
    public int setBit(int num,int index)
    {
        return (num | (1<<index));
    }
    public int unsetBit(int num,int index)
    {
        return (num & ~(1<<index));
    }
}
//Approach 2:
class Solution {
    public int minimizeXor(int num1, int num2) {
        int res=0;//suppose if bit count is equal of but num1 and num2 then num1^num1=0(min)
        int required=Integer.bitCount(num2);
         for(int bit = 31; bit >= 0 && required > 0; bit--) {
            if(isSet(num1, bit)) {
                res|= (1 << bit);
                required--;
            }
        }

        for(int bit = 0; bit < 32 && required > 0; bit++) {
            if(!isSet(num1, bit)) {
                res|= (1 << bit);
                required--;
            }
        }
        return res;
    }
    public boolean isSet(int num,int index)
    {
        return (num & (1<<index))!=0;
    }
}