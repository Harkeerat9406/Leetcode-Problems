class Solution {
    List<List<Integer>> ans= new ArrayList<>();

    public void helper(int idx, int n, int prev, int arr[], List<Integer> list)
    {
        if (list.size() >= 2)
            ans.add(new ArrayList<>(list));

        if(idx==n)
            return;

        HashSet<Integer> set= new HashSet<>();
        for(int i=idx; i<n; i++)
        {
            if(set.contains(arr[i]))
                continue;

            if(arr[i] >= prev)
            {
                list.add(arr[i]);
                helper(i+1, n, arr[i], arr, list);
                list.remove(list.size()-1);
            }
            set.add(arr[i]);
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(0, nums.length, -101, nums, new ArrayList<>());
        return ans;
    }
}