class Solution {
    public int maxCoins(int[] arr) {
        int n= arr.length, sum=0;
        Arrays.sort(arr);
        int left=0, right= n-2;

        while(left<right)
        {
            sum+= arr[right];
            right-= 2;
            left++;
        }
        return sum;
    }
}