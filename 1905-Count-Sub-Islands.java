class Solution {
    public boolean dfs(int grid1[][], int grid2[][], boolean visit[][], int i, int j, int n, int m)
    {
        if(i<0 || i>=n || j<0 || j>=m || visit[i][j] || grid2[i][j]==0)
            return true;
        
        boolean currOk= true;
        if(grid1[i][j] == 0)
            currOk= false;
        
        visit[i][j]= true;

        boolean down= dfs(grid1, grid2, visit, i+1, j, n, m);
        boolean up= dfs(grid1, grid2, visit, i-1, j, n, m);
        boolean left= dfs(grid1, grid2, visit, i, j-1, n, m);
        boolean right= dfs(grid1, grid2, visit, i, j+1, n, m);

        return currOk && left && right && up && down;     
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n= grid1.length, m= grid1[0].length;
        boolean visit[][]= new boolean[n][m];
        int count=0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid2[i][j]==1 && !visit[i][j])
                {
                    if(grid1[i][j]==1 && dfs(grid1, grid2, visit, i, j, n, m))
                        count++;
                }
            }
        }
        return count;
    }
}