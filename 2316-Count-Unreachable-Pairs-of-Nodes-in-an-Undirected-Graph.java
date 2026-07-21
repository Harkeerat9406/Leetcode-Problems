class Solution {
    long count;

    public void dfs(List<List<Integer>>list, boolean visit[], int node)
    {
        for(int i: list.get(node))
        {
            if(!visit[i])
            {
                count++;
                visit[i]= true;
                dfs(list, visit, i);
            }
        }
    }

    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> list= new ArrayList<>();
        boolean visited[]= new boolean[n];

        for(int i=0; i<n; i++)
        {
            list.add(new ArrayList<>());
        }

        int elen= edges.length;
        for(int i=0; i<elen; i++)
        {
            int u= edges[i][0];
            int v= edges[i][1];

            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        long sum;
        if(n%2==0)
            sum= 1L*(n/2)*(n-1);
        else
            sum= 1L*n* ((n-1)/2);

        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                count=1;
                visited[i]= true;
                dfs(list, visited, i);
            }
            sum-= count * (count-1) / 2;
            count=0;
        }
        return sum;    
    }
}