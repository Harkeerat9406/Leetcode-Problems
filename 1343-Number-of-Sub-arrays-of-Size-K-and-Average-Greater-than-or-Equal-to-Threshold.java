class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i=0, j=0, sum=0, count=0;
        int n= arr.length, size;
        
        for(j=0; j<k; j++)
            sum+= arr[j];
        j--;

        while(j<n)
        {
            size= j-i+1;

            if(sum/size >= threshold)
                count++;
            
            sum-= arr[i];
            i++;
            j++;
            if(j<n)
            {
                sum+= arr[j];
            }
        }
        return count;
    }
}