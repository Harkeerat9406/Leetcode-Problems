class Solution {
    public int[] frequencySort(int[] nums) {
        int n= nums.length;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0; i<n; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        int arr[][]= new int[map.size()][2];
        int idx=0;
        for(Integer key: map.keySet())
        {
            arr[idx][0]= key;
            arr[idx][1]= map.get(key);
            idx++;
        }

        Arrays.sort(arr, (a,b) -> {
            if(a[1]==b[1])
                return Integer.compare(b[0], a[0]);
            else
                return Integer.compare(a[1], b[1]);
        });

        int ans[]= new int[n];
        int arrLen= arr.length;
        idx=0;
        for(int i=0; i<arrLen; i++)
        {
            int freq= arr[i][1];
            while(freq>0)
            {
                ans[idx]= arr[i][0];
                freq--;
                idx++;
            }
        }
        return ans;

    }
}