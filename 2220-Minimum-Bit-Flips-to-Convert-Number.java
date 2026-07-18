class Solution {
    public int minBitFlips(int start, int goal) {
        int x= start^goal, flips=0;

        while(x>0)
        {
            if((x&1)==1)
                flips++;
            x>>= 1;
        }
        return flips;
    }
}