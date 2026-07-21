class Solution {
    int r2, c2;
    public void dfs(int arr[][], boolean visit[][], int i, int j, int n, int m)
    {
        if(i<0 || j<0 || i==n || j==m || visit[i][j] || arr[i][j]!=1)
            return;
        
        visit[i][j]= true;
        if((i+1==n || arr[i+1][j]==0) && (j+1==m || arr[i][j+1]==0))
        {
            r2= i;
            c2= j;
            return;
        }

        dfs(arr, visit, i+1, j, n, m);      // down
        dfs(arr, visit, i-1, j, n, m);      // up
        dfs(arr, visit, i, j-1, n, m);      // left;
        dfs(arr, visit, i, j+1, n, m);      // right
    }

    public int[][] findFarmland(int[][] land) {
        int n= land.length, m= land[0].length;
        boolean visit[][]= new boolean[n][m];
        List<int[]> list= new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(land[i][j]==1 && !visit[i][j])
                {
                    int r1=i, c1=j;
                    dfs(land, visit, i, j, n, m);
                    list.add(new int[]{r1, c1, r2, c2});
                }
            }
        }
        int ans[][]= new int[list.size()][4];
        int len= ans.length;
        
        for(int i=0; i<len; i++)
        {
            ans[i]= list.get(i);
        }
        return ans;
    }
}