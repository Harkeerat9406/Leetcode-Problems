class Solution {
    public void dfs(int[][] arr, int n, int m, int row, int col, int color, int match)
    {
        //check left
        if(col-1>=0 && arr[row][col-1]==match)
        {
            arr[row][col-1]= color;
            dfs(arr, n, m, row, col-1, color, match);
        }

        //check right
        if(col+1<m && arr[row][col+1]==match)
        {
            arr[row][col+1]= color;
            dfs(arr, n, m, row, col+1, color, match);
        }

        //check down
        if(row+1<n && arr[row+1][col]==match)
        {
            arr[row+1][col]= color;
            dfs(arr, n, m, row+1, col, color, match);
        }
        
        //check up
        if(row-1>=0 && arr[row-1][col]==match)
        {
            arr[row-1][col]= color;
            dfs(arr, n, m, row-1, col, color, match);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)
            return image;

        int match = image[sr][sc];
        image[sr][sc] = color;

        dfs(image, image.length, image[0].length, sr, sc, color, match);
        return image;
    }
}