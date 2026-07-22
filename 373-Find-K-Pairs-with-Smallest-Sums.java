class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length==0 || nums2.length==0 || k==0)
            return new ArrayList<>();
        int n1= nums1.length, n2= nums2.length;

        PriorityQueue<int[]> q= new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        List<List<Integer>> list= new ArrayList<>();
        HashSet<String> set= new HashSet<>();

        set.add(0+","+0);
        q.add(new int[]{nums1[0]+nums2[0], 0, 0});

        while(k>0 && !q.isEmpty())
        {
            int arr[]= q.poll();
            int i= arr[1], j=arr[2];

            list.add((Arrays.asList(nums1[i], nums2[j])));
            
            // add (i+1, j)
            if(i<n1-1 && !set.contains((i+1)+","+j))
            {
                set.add((i+1)+","+j);
                int sum= nums1[i+1]+nums2[j];
                q.add(new int[]{sum, i+1, j});
            }

            // add (i, j+1)
            if(j<n2-1 && !set.contains((i)+","+(j+1)))
            {
                set.add(i+","+(j+1));
                int sum= nums1[i]+nums2[j+1];
                q.add(new int[]{sum, i, j+1});
            }
            k--;
        }
        return list;
    }
}