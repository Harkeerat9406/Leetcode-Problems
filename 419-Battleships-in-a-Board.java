class Solution {
    public void dfs(int row, int col, char arr[][], boolean visit[][], int n, int m)
    {
        // check up
        if(row-1>=0 && arr[row-1][col]=='X' && !visit[row-1][col])
        {
            visit[row-1][col]= true;
            dfs(row-1, col, arr, visit, n, m);
        }

        // check down
        if(row+1<n && arr[row+1][col]=='X' && !visit[row+1][col])
        {
            visit[row+1][col]= true;
            dfs(row+1, col, arr, visit, n, m);
        }

        // check left
        if(col-1>=0 && arr[row][col-1]=='X' && !visit[row][col-1])
        {
            visit[row][col-1]= true;
            dfs(row, col-1, arr, visit, n, m);
        }

        // check right
        if(col+1<m && arr[row][col+1]=='X' && !visit[row][col+1])
        {
            visit[row][col+1]= true;
            dfs(row, col+1, arr, visit, n, m);
        }
    }

    public int countBattleships(char[][] arr) {
        int n= arr.length, m= arr[0].length;
        boolean visit[][]= new boolean[n][m];
        int count=0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(arr[i][j]=='X' && !visit[i][j])
                {
                    visit[i][j]= true;
                    count++;
                    dfs(i, j, arr, visit, n, m);
                }
            }
        }
        return count;
    }
}