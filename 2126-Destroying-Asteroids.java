class Solution {
    public boolean asteroidsDestroyed(int mass, int[] arr) {
        int n= arr.length;
        int max= Integer.MIN_VALUE;
        for(int i: arr)
        {
            max= Math.max(max, i);
        }

        int freq[]= new int[max + 1];
        for(int i: arr)
        {
            freq[i]++;
        }

        long sum= mass;

        for(int i=1; i<=max; i++)
        {
            if(freq[i]>0 && sum >= i)
            {
                sum+= 1L*i*freq[i];
            }
            else if(freq[i]>0 && sum<i)
                return false;
        }
        return true;
    }
}