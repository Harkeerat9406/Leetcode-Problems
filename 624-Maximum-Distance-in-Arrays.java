class Solution {
    public int maxDistance(List<List<Integer>> arr) {
        List<Integer> list= arr.get(0);
        int gmin= list.get(0), gmax= list.get(list.size()-1);
        int n= arr.size(), maxDist=0;

        for(int i=1; i<n; i++)
        {
            list= arr.get(i);
            int first= list.get(0);
            int last= list.get(list.size()-1);

            maxDist= Math.max(Math.abs(gmax-first), maxDist);
            maxDist= Math.max(Math.abs(gmin-last), maxDist);

            gmax= Math.max(gmax, last);
            gmin= Math.min(gmin, first);
        }
        return maxDist;
    }
}