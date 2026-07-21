class Solution {
    public int diagonalPrime(int[][] arr) {
        int end= 4_000_000;
        boolean prime[]= new boolean[end+1];
        Arrays.fill(prime, true);
        prime[0]= false;
        prime[1]= false;

        for(int i=2; i*i <= end; i++)
        {
            if(prime[i])
            {
                for(int j=i*i; j<=end; j+=i)
                {
                    prime[j]= false;
                }
            }
        }

        int n= arr.length, m= arr[0].length, max= 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                int leftDiag= arr[i][i];
                int rightDiag= arr[i][n-i-1];

                if(prime[leftDiag])
                    max= Math.max(max, leftDiag);

                if(prime[rightDiag])
                    max= Math.max(max, rightDiag);
            }
        }
        return max;
    }
}