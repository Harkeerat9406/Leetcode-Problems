class Solution {
    public int[] arrayRankTransform(int[] nums) {
        int n= nums.length;
        if(n==0)
            return nums;

        int arr[][]= new int[n][2];
        for(int i=0; i<n; i++)
        {
            arr[i][0]= nums[i];
            arr[i][1]= i;
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        int ans[]= new int[n];
        int rank= 1;
        ans[arr[0][1]]= 1;

        for(int i=1; i<n; i++)
        {
            if(arr[i][0] == arr[i-1][0])
            {
                ans[arr[i][1]]= rank;
            }
            else
            {
                ans[arr[i][1]]= ++rank;
            }
        }
        return ans;
    }
}