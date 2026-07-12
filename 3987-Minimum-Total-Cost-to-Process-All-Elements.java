class Solution {
    public int minimumCost(int[] nums, int k) {
        long cost=0, res=k, running=1;
        long mod= 1_000_000_007;
        for(long i: nums)
            {
                if(i <= res)
                {
                    res-= i;
                }
                else
                {
                    long diff= (i-res);
                    long factor= (diff+k-1)/k;
                    
                    res+= (factor*k);
                    res-= i;

                    long last= running + (factor-1);
                    long term1 = last + running;
                    long term2 = last - running + 1;
                    long sum;
                    if (term1 % 2 == 0) {
                        sum = ((term1 / 2) % mod) * (term2 % mod) % mod;
                    } else {
                        sum = (term1 % mod) * ((term2 / 2) % mod) % mod;
                    }
                    cost = (cost + sum) % mod;
                    running= last+1;
                }
            }
        return (int)cost;
    }
}