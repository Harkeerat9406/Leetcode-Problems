class Solution {
    public int minSubArrayLen(int k, int[] arr) {
        int i=0, j=0, min= Integer.MAX_VALUE;
        int n= arr.length, sum=0;
        while(j<n)
        {
            sum+= arr[j];

            while(sum>=k)
            {
                sum-= arr[i];
                min= Math.min(j-i+1, min);
                i++;
            }
            j++;
        }
        if(min > n)
            return 0;

        return min;
    }
}