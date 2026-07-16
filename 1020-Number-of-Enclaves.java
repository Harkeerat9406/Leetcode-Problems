class Solution {
    int count;

    public boolean dfs(int arr[][], boolean visit[][], int i, int j, int n, int m)
    {
        if((i==0 || i==n-1 || j==0 || j==m-1) && arr[i][j]==1)
            return false;
        
        else if(arr[i][j]==0 || visit[i][j])
            return true;
        
        visit[i][j]= true;

        boolean left= dfs(arr, visit, i, j-1, n, m);       // left
        boolean right= dfs(arr, visit, i, j+1, n, m);      // right
        boolean up= dfs(arr, visit, i-1, j, n, m);         // up
        boolean down= dfs(arr, visit, i+1, j, n, m);      // down
        
        if(left && right && up && down)
        {
            count++;
            return true;
        }

        count= 0;
        return false;
    }

    public int numEnclaves(int[][] grid) {
        int n= grid.length, m= grid[0].length;
        boolean visit[][]= new boolean[n][m];
        int land=0;

        for(int i=1; i<n-1; i++)
        {
            for(int j=1; j<m-1; j++)
            {
                if(grid[i][j]==1 && !visit[i][j])
                {
                    dfs(grid, visit, i, j, n, m);
                    land+= count;
                    count=0;
                }
            }
        }
        return land;
    }
}