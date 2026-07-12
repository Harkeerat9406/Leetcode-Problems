class Solution {
    public void dfs(int node, boolean visit[], int arr[][], int n)
    {
        visit[node]= true;

        for(int i=0; i<n; i++)
        {           
            if(arr[node][i]==1 && !visit[i])
                dfs(i, visit, arr, n);
        }
    }

    public int findCircleNum(int[][] arr) {
        int n= arr.length, count=0;
        boolean visit[]= new boolean[n];
        
        for(int i=0; i<n; i++)
        {
            if(!visit[i])
            {
                count++;
                dfs(i, visit, arr, n);
            }
        }
        return count;
    }
}