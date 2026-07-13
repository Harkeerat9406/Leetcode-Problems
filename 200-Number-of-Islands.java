class Solution {
    public void dfs(int row, int col, char arr[][], boolean visit[][], int n, int m)
    {
        // check up
        if(row-1>=0 && arr[row-1][col]=='1' && !visit[row-1][col])
        {
            visit[row-1][col]= true;
            dfs(row-1, col, arr, visit, n, m);
        }

        // check down
        if(row+1<n && arr[row+1][col]=='1' && !visit[row+1][col])
        {
            visit[row+1][col]= true;
            dfs(row+1, col, arr, visit, n, m);
        }

        // check left
        if(col-1>=0 && arr[row][col-1]=='1' && !visit[row][col-1])
        {
            visit[row][col-1]= true;
            dfs(row, col-1, arr, visit, n, m);
        }

        // check right
        if(col+1<m && arr[row][col+1]=='1' && !visit[row][col+1])
        {
            visit[row][col+1]= true;
            dfs(row, col+1, arr, visit, n, m);
        }
    }
    public int numIslands(char[][] arr) {
        int n= arr.length, m= arr[0].length;
        boolean visit[][]= new boolean[n][m];
        int count=0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(!visit[i][j] && arr[i][j]=='1')
                {
                    visit[i][j]= true;
                    dfs(i, j, arr, visit, n, m);
                    count++;
                }
            }
        }
        return count;
    }
}