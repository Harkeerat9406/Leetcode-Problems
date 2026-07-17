class Solution {
    public boolean dfs(int [][]grid, boolean visit[][], int i, int j, int n, int m, int myCol, boolean change[][])
    {
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]!=myCol)
            return true;
        
        if(visit[i][j])
            return false;

        visit[i][j]= true;
        
        boolean left= dfs(grid, visit, i, j-1, n, m, myCol, change);
        boolean right= dfs(grid, visit, i, j+1, n, m, myCol, change);
        boolean up= dfs(grid, visit, i-1, j, n, m, myCol, change);
        boolean down= dfs(grid, visit, i+1, j, n, m, myCol, change);

        if(left || right || up || down)
            change[i][j]= true;
        
        return false;
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n= grid.length, m= grid[0].length;
        boolean visit[][]= new boolean[n][m];
        int myCol= grid[row][col];
        boolean change[][]= new boolean[n][m];

        visit[row][col]= true;

        boolean left= dfs(grid, visit, row, col-1, n, m, myCol, change);
        boolean right= dfs(grid, visit, row, col+1, n, m, myCol, change);
        boolean up= dfs(grid, visit, row-1, col, n, m, myCol, change);
        boolean down= dfs(grid, visit, row+1, col, n, m, myCol, change);

        if(left || right || up || down)
            change[row][col]= true;
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(change[i][j])
                    grid[i][j]= color;
            }
        }
        return grid;
    }
}