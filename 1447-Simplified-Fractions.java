class Solution {
    public int gcd(int a, int b)
    {
        while(b!=0)
        {
            int temp= b;
            b= a%b;
            a= temp;
        }
        return a;
    }

    public List<String> simplifiedFractions(int n) {
        List<String> ans= new ArrayList<>();

        for(int i=2; i<=n; i++)
        {
            for(int j=1; j<i; j++)
            {
                if(gcd(i, j)==1)
                {
                    ans.add(j+"/"+i);
                }
            }
        }
        return ans;
    }
}