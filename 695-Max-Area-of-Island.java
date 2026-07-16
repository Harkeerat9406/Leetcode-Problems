class Solution {
    public int dfs(int arr[][], boolean visit[][], int i, int j, int n, int m)
    {
        if(i<0 || i==n || j<0 || j==m || visit[i][j] || arr[i][j]!=1)
            return 0;
        
        visit[i][j]= true;
        
        return dfs(arr, visit, i+1, j, n, m)   // down
            + dfs(arr, visit, i-1, j, n, m)    // up
            + dfs(arr, visit, i, j+1, n, m)    // right
            + dfs(arr, visit, i, j-1, n, m)    // left
            + 1;    // curr
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n= grid.length, m= grid[0].length;
        boolean visit[][]= new boolean[n][m];
        int maxArea= 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j]==1 && !visit[i][j])
                {
                    int area= dfs(grid, visit, i, j, n, m);
                    maxArea= Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}