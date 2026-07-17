class Solution {
    public int reverseBits(int n) {
        int rev= 0, iter=0;

        while(iter++ <32)
        {
            if((n&1)==1)  // bit is 1
            {
                rev= rev|1;
            } 
            if(iter!=32) rev= rev<<1;
            n= n>>1;
        }
        return rev;
    }
}