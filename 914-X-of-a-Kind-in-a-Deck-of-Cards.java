class Solution {
    public int findGcd(int x, int y)
    {
        int a= Math.max(x,y);
        int b= Math.min(x,y);

        while(b!=0)
        {
            int temp= b;
            b= a%b;
            a= temp;
        }
        return a;
    }
    
    public boolean hasGroupsSizeX(int[] arr) {
        HashMap<Integer, Integer> map= new HashMap<>();
        int n= arr.length;

        for(int i=0; i<n; i++)
        {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        int gcd=-1;

        for(Integer i: map.values())
        {
            if(gcd==-1)
            {
                gcd= i;
                continue;
            }

            gcd= findGcd(gcd, i);
            if(gcd==1)
                return false;
        }
        return gcd!=1;
    }
}