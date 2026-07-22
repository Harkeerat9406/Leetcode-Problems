class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map= new HashMap<>();
        int n= nums.length;

        for(int i=0; i<n; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Integer> q= new PriorityQueue<>(); 
        for(Integer i: map.values())
        {
            q.offer(i);
            if(q.size() > k)
                q.poll();
        }

        HashSet<Integer> set= new HashSet<>();
        while(!q.isEmpty())
        {
            set.add(q.poll());
        }

        List<Integer> list= new ArrayList<>();
        for(Integer key: map.keySet())
        {
            if(set.contains(map.get(key)))
                list.add(key);
        }

        int arr[]= new int[list.size()];
        n= arr.length;

        for(int i=0; i<n; i++)
        {
            arr[i]= list.get(i);
        } 
        return arr;
    }
}