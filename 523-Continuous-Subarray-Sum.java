class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        int n= nums.length, sum=0;
        map.put(0,-1);

        for(int i=0; i<n; i++)
        {
            sum+= nums[i];
            int rem= sum%k;

            int idx= map.getOrDefault(rem, i);
            
            if(i-idx > 1)
                return true;
            
            map.put(rem, idx);
        }
        return false;
    }
}