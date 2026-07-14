class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int i=0, j= arr.length-1;
        int count=0;

        while(i<=j)
        {
            if(arr[i]+arr[j] <= limit)
                i++;
            
            count++;
            j--;
        }
        return count;
    }
}