class Solution {
    public long maximumValue(int n, int s, int m) {
        long max=s;

        if(n==1) return s;

        if(n%2==0)
        {
            max+= 0L + (1L*m*(n/2)) - (1L * (n-1)/2);
        }
        else
        {
            max+= 0L + (1L*m*((n-1)/2)) - (1L * (n-2)/2) ;
        }
        return max;

        
    }
}