class Solution {
    public int maxSubarrayLength(int[] arr, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        int n= arr.length, exceed=0;
        int i=0, j=0, max= 0;
        
        while(j<n)
        {
            int num= arr[j];
            map.put(num, map.getOrDefault(num, 0)+1);

            if(map.get(num) > k)
                exceed++;

            while(exceed > 0 && i<=j)
            {
                int x= arr[i];
                int freq= map.get(x);
                if(freq == k+1)
                    exceed--;
                
                map.put(x, freq-1);
                i++;
            }
            max= Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}