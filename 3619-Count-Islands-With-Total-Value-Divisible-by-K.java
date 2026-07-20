class Solution {
    public long dfs(int arr[][], int i, int j, int n, int m, boolean visit[][])
    {
        if(i<0 || i>=n || j<0 || j>=m || visit[i][j] || arr[i][j]==0)
            return 0;

        visit[i][j]= true;
        long sum= arr[i][j];

        sum+= dfs(arr, i+1, j, n, m, visit);
        sum+= dfs(arr, i-1, j, n, m, visit);
        sum+= dfs(arr, i, j+1, n, m, visit);
        sum+= dfs(arr, i, j-1, n, m, visit);

        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int n= grid.length, m= grid[0].length;
        boolean visit[][]= new boolean[n][m];
        int count=0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j]!=0 && !visit[i][j])
                {
                    long sum= dfs(grid, i, j, n, m, visit);
                    if(sum%k==0)
                        count++;
                }
            }
        }
        return count;
    }
}