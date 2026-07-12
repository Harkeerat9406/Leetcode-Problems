class Solution {
    List<List<Integer>> list= new ArrayList<>();
    public void buildAdj(int arr[][], int n)
    {
        for(int i=0; i<n; i++)
        {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<arr.length; i++)
        {
            int u= arr[i][0];
            int v= arr[i][1];

            list.get(u).add(v);
            list.get(v).add(u);
        }
    }

    public boolean dfs(boolean visit[], int node, int end)
    {
        if(node == end)
            return true;
        
        visit[node]= true;

        for(int i: list.get(node))
        {
            boolean found= false;
            if(!visit[i])
                found= dfs(visit, i, end);
            
            if(found)
                return true;
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        buildAdj(edges, n);
        boolean visit[]= new boolean[n];

        return dfs(visit, source, destination);
    }
}