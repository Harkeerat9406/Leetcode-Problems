class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q= new PriorityQueue<>(Collections.reverseOrder());
        int n= stones.length;

        for(int i=0; i<n; i++)
        {
            q.offer(stones[i]);
        }

        while(q.size()>1)
        {
            int y= q.poll();
            int x= q.poll();

            int rem= y-x;
            if(rem!=0)
                q.offer(rem);
        }
        if(q.size()==0)
            return 0;
        
        return q.poll();
    }
}