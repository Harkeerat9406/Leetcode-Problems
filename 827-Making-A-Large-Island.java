class Solution {
    HashMap<Integer, Integer> map= new HashMap<>();
    int size=0;

    public void dfs(int arr[][], int i, int j, int n, int id)
    {
        if(i<0 || i>=n || j<0 || j>=n || arr[i][j]!=1)
            return;
        
        size++;
        arr[i][j]= id;
    
        dfs(arr, i+1, j, n, id);
        dfs(arr, i-1, j, n, id);
        dfs(arr, i, j+1, n, id);
        dfs(arr, i, j-1, n, id);
    }

    public int findSize(int arr[][], int i, int j, int n)
    {
        int totalSize=0;
        int usedId[]= new int[3];
        boolean alreadyUsed= false;

        // check above
        if(i>0)
        {
            totalSize+= map.getOrDefault(arr[i-1][j], 0);
            usedId[0]= arr[i-1][j];
        }

        // check below
        if(i<n-1)
        {
            alreadyUsed= false;
            for(int id: usedId)
            {
                if(id==arr[i+1][j])
                    alreadyUsed= true;
            }
            if(!alreadyUsed)
                totalSize+= map.getOrDefault(arr[i+1][j], 0);
            
            usedId[1]= arr[i+1][j];
        }
        
        // check left
        if(j>0)
        {
            alreadyUsed= false;
            for(int id: usedId)
            {
                if(id==arr[i][j-1])
                    alreadyUsed= true;
            }
            if(!alreadyUsed)
                totalSize+= map.getOrDefault(arr[i][j-1], 0);
            
            usedId[2]= arr[i][j-1];
        }
        
        //check right
        if(j<n-1)
        {
            alreadyUsed= false;
            for(int id: usedId)
            {
                if(id==arr[i][j+1])
                    alreadyUsed= true;
            }
            if(!alreadyUsed)
                totalSize+= map.getOrDefault(arr[i][j+1], 0);
        }
        return totalSize+1;
    }

    public int largestIsland(int[][] grid) {
        int n= grid.length;
        int id= 2, max=0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]==1)
                {
                    size=0;
                    dfs(grid, i, j, n, id);
                    map.put(id, size);
                    id++;
                    max= Math.max(max, size);
                }
            }
        }

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]==0)
                {
                    max= Math.max(max, findSize(grid, i, j, n));
                }
            }
        }
        return max;
    }
}