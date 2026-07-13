class Solution {
    List<List<String>> ans= new ArrayList<>();

    public void convertToList(char arr[][], int n)
    {
        List<String> list= new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            StringBuilder sb= new StringBuilder();
            for(int j=0; j<n; j++)
            {
                if(arr[i][j] == 'Q')
                    sb.append('Q');
                else
                    sb.append('.');
            }
            list.add(new String(sb));
        }
        ans.add(list);
    }

    public void helper(int row, char[][] arr, int n)
    {
        if(row == n)
        {
            convertToList(arr, n);
            return;
        }

        for(int i=0; i<n; i++)
        {
            if(isValid(row, i, arr, n))
            {
                arr[row][i]= 'Q';
                helper(row+1, arr, n);
                arr[row][i]= '0';
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


    public List<List<String>> solveNQueens(int n) {
        char[][] arr= new char[n][n];

        helper(0, arr, n);
        return ans;
    }
}