class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int n= arr.length;
        int product=1, left=0, right=0;
        int count=0;

        while(right<n)
        {
            product*= arr[right];

            while(left<n && product>=k)
            {
                product/= arr[left];
                left++;
            }

            count+= (right-left+1);
            right++;
        }
        return count;
    }
}