class Solution {
    int count=0;
    public void helper(int row, char[][] arr, int n)
    {
        if(row == n)
        {
            count++;
            return;
        }

        for(int i=0; i<n; i++)
        {
            if(isValid(row, i, arr, n))
            {
                arr[row][i]= 'Q';
                helper(row+1, arr, n);
                arr[row][i]= '.';
            }
        }
    }

    public boolean isValid(int row, int col, char arr[][], int n)
    {
        // check straight up
        for(int i=row-1; i>=0; i--)
        {
            if(arr[i][col] == 'Q')
                return false;
        }

        // check left upper diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--)
        {
            if(arr[i][j] == 'Q')
                return false;
        }

        // check right upper diagonal
        for(int i= row-1, j= col+1; i>=0 && j<n; i--, j++)
        {
            if(arr[i][j] == 'Q')
                return false;
        }
        return true;
    }


    public int totalNQueens(int n) {
        char[][] arr= new char[n][n];
        for(int i=0; i<n; i++)
        {
            Arrays.fill(arr[i], '.');
        }
        
        helper(0, arr, n);
        return count;
    }
}