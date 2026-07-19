class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        long midRange= 0, lastRange=0;
        long ops=0, mod= 1_000_000_007;

        for(int i: nums)
            {
                if(i<a)
                {
                    ops= (ops + midRange + lastRange) % mod;
                }
                else if(i>=a && i<=b)
                {
                    ops= (ops + lastRange) % mod;
                    midRange++;
                }
                else if(i>b)
                {
                    lastRange++;
                }
            }
        return (int)(ops%mod);
    }
}