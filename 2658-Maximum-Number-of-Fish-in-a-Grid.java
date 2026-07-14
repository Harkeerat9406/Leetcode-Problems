class Solution {
    public int dfs(int row, int col, int arr[][], boolean visit[][], int n, int m)
    {
        if(row<0 || row>=n || col<0 || col>=m || visit[row][col] || arr[row][col]==0)
            return 0;
        
        visit[row][col]= true;

        return arr[row][col] + dfs(row-1, col, arr, visit, n, m) +
            dfs(row+1, col, arr, visit, n, m) + 
            dfs(row, col-1, arr, visit, n, m) + 
            dfs(row, col+1, arr, visit, n, m);
    }

    public int findMaxFish(int[][] arr) {
        int n= arr.length, m= arr[0].length;
        boolean visit[][]= new boolean[n][m];
        int max= 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                int sum= dfs(i, j, arr, visit, n, m);
                max= Math.max(sum, max);
            }
        }
        return max;
    }
}