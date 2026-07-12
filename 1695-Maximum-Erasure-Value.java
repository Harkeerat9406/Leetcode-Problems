class Solution {
    public int maximumUniqueSubarray(int[] arr) {
        HashMap<Integer, Integer> map= new HashMap<>();
        int i=0, j=0, max= 0, sum= 0;
        int n= arr.length;

        while(j<n)
        {
            int idx= map.getOrDefault(arr[j], -1);
            sum+= arr[j];

            while(idx!=-1 && idx>=i)
            {
                sum-= arr[i];
                map.put(arr[i], -1);
                i++;
            }
            map.put(arr[j], j);
            max= Math.max(max, sum);
            j++;
        }
        return max;
    }
}