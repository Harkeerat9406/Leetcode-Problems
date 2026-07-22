class Solution {
    public int totalHammingDistance(int[] nums) {
        int n= nums.length, sum=0;
        int prefix0[]= new int[32];
        int prefix1[]= new int[32];

        for(int i=0; i<n; i++)
        {
            int num= nums[i];
            int idx=0;

            while(idx<=31)
            {
                if((num&1)==1)
                {
                    sum+= prefix0[idx];
                    prefix1[idx]++;
                }
                else
                {
                    sum+= prefix1[idx];
                    prefix0[idx]++;
                }
                num>>= 1;
                idx++;
            }
        }
        return sum;
    }
}