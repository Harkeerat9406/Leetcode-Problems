class Solution {
    public int maxIceCream(int[] arr, int coins) {
        Arrays.sort(arr);
        int i=0, n= arr.length;
        int count=0; 

        while(coins>0 && i<n)
        {
            if(arr[i] > coins)
                break;
            
            count++;
            coins-= arr[i];
            i++;
        }
        return count;
    }
}