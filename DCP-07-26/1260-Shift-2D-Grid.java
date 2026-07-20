class Solution {
    public void reverse(int arr[][], int start, int end, int cols)
    {
        while(start<end)
        {
            int temp= arr[start/cols][start%cols];
            arr[start/cols][start%cols] = arr[end/cols][end%cols];
            arr[end/cols][end%cols]= temp;

            start++;
            end--;
        }
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int cols= grid[0].length, rows= grid.length;
        int n= cols*rows;
        k= k % n;

        reverse(grid, 0, n-1, cols);
        reverse(grid, 0, k-1, cols);
        reverse(grid, k, n-1, cols);

        List<List<Integer>> ans= new ArrayList<>();

        for(int i=0; i<rows; i++)
        {
            List<Integer> list= new ArrayList<>();
            for(int j=0; j<cols; j++)
            {
                list.add(grid[i][j]);
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}