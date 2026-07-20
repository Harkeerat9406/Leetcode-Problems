class Solution {
    public long maximumMedianSum(int[] nums) {
        long sum= 0;
        Arrays.sort(nums);
        int left= 0, right= nums.length-1;

        while(left<right)
        {
            sum+= nums[right-1];
            left++;
            right-= 2;
        }
        return sum;
    }
}