class Solution {
    boolean used[];
    int n, target;

    public boolean helper(int idx, int sum, int arr[], int k)
    {
        if(k==1)                // the sum of rem nums is equal to target
            return true;
        
        if(sum == target)       // create another subset
            return helper(0, 0, arr, k-1);
        
        if(idx == n)            // if we reached end & sum!=target, means false
            return false;

        for(int i= idx; i<n; i++)
        {
            if(used[i] || sum+arr[i]>target)
                continue;
            
            used[i]= true;
            if(helper(i+1, sum+arr[i], arr, k))
                return true;
            
            used[i]= false;
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] arr, int k) {
        n= arr.length;
        Arrays.sort(arr);
        int sum=0;

        for(int i: arr)
        {
            sum+= i;
        }
        if(sum%k != 0)
            return false;

        // reverse array for pruning
        for (int i=0; i<n/2; i++) 
        {
            int temp= arr[i];
            arr[i]= arr[n-1-i];
            arr[n-1-i]= temp;
        }
        
        target= sum/k;
        used= new boolean[n];
        return helper(0, 0, arr, k);
    }
}