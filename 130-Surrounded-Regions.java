class Solution {
    public void dfs(int row, int col, char arr[][], int n, int m, boolean visit[][])
    {
        // check up
        if(row-1>=0 && arr[row-1][col]=='O' && !visit[row-1][col])
        {
            visit[row-1][col]= true;
            arr[row-1][col]= '#';
            dfs(row-1, col, arr, n, m, visit);
        }

        // check down
        if(row+1<n && arr[row+1][col]=='O' && !visit[row+1][col])
        {
            visit[row+1][col]= true;
            arr[row+1][col]= '#';
            dfs(row+1, col, arr, n, m, visit);
        }

        // check left
        if(col-1>=0 && arr[row][col-1]=='O' && !visit[row][col-1])
        {
            visit[row][col-1]= true;
            arr[row][col-1]= '#';
            dfs(row, col-1, arr, n, m, visit);
        }

        // check right
        if(col+1<m && arr[row][col+1]=='O' && !visit[row][col+1])
        {
            visit[row][col+1]= true;
            arr[row][col+1]= '#';
            dfs(row, col+1, arr, n, m, visit);
        }
    }

    public void solve(char[][] arr) {
        int n= arr.length, m= arr[0].length;
        boolean visit[][]= new boolean[n][m];

        // first and last row
        for(int i=0; i<m; i++)
        {
            if(arr[0][i]=='O' && !visit[0][i])
            {
                visit[0][i]= true;
                arr[0][i]= '#';
                dfs(0, i, arr, n, m, visit);
            }

            if(arr[n-1][i]=='O' && !visit[n-1][i])
            {
                visit[n-1][i]= true;
                arr[n-1][i]= '#';
                dfs(n-1, i, arr, n, m, visit);
            }
        }

        // first and last column
        for(int i=0; i<n; i++)
        {
            if(arr[i][0]=='O' && !visit[i][0])
            {
                visit[i][0]= true;
                arr[i][0]= '#';
                dfs(i, 0, arr, n, m, visit);
            }

            if(arr[i][m-1]=='O' && !visit[i][m-1])
            {
                visit[i][m-1]= true;
                arr[i][m-1]= '#';
                dfs(i, m-1, arr, n, m, visit);
            }
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(arr[i][j] == 'O')
                    arr[i][j]= 'X';

                else if(arr[i][j] == '#')
                    arr[i][j]= 'O';
            }
        }
    }
}