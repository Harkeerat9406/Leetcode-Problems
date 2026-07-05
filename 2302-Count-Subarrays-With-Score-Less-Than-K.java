class Solution {
    public long countSubarrays(int[] arr, long k) {
        long sum=0, product=1, count=0;
        int i=0, j=0, n=arr.length;

        while(j<n)
        {
            sum+= arr[j];
            product= sum*(j-i+1);
            
            while(i<=j && product>=k)
            {
                sum-= arr[i];
                i++;
                product= sum*(j-i+1);
            }
            count+= (j-i+1);
            j++;
        }
        return count;
    }
}