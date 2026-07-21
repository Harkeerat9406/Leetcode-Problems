class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> smaller= new ArrayList<>();
        List<Integer> larger= new ArrayList<>();

        for(int i=1; i*i<=n; i++)
        {
            if(n%i==0)
            {
                smaller.add(i);
                if(n/i != i)
                    larger.add(n/i);
            }
        }

        int ssize= smaller.size();
        int i=0;
        while(i<ssize)
        {
            if(k==1)
                return smaller.get(i);
            
            i++;
            k--;
        }
        i= larger.size()-1;

        while(i>=0)
        {
            if(k==1)
                return larger.get(i);
            
            i--;
            k--;
        }
        return -1;
    }
}