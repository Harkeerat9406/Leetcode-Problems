class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1=0, sum2=0;
        int n1= nums1.length, n2= nums2.length;
        int count1=0, count2=0;

        for(int i=0; i<n1; i++)
        {
            sum1+= nums1[i];
            if(nums1[i]==0) count1++;
        }

        for(int i=0; i<n2; i++)
        {
            sum2+= nums2[i];
            if(nums2[i]==0) count2++;
        }

        if(count1==0 && sum2+count2>sum1 || count2==0 && sum1+count1>sum2)
            return -1;
        
        if(count1==0 && sum1-sum2 == count2-1)
            return -1;

        if(count2==0 && sum2-sum1 == count1-1)
            return -1;
        
        sum1+= count1;
        sum2+= count2;

        return Math.max(sum1, sum2);
    }
}