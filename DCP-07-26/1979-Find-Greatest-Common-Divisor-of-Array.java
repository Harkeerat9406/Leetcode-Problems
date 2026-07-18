class Solution {
    public int findGCD(int[] arr) {
        int n= arr.length;
        int min= arr[0], max= arr[n-1];

        for(int i=0; i<n; i++)
        {
            max= Math.max(max, arr[i]);
            min= Math.min(min, arr[i]);
        }

        while(min!=0)
        {
            int temp= min;
            min= max%min;
            max= temp;
        }
        return max;
    }
}