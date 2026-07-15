class Solution {
    public int minimumRounds(int[] arr) {
        HashMap<Integer, Integer> map= new HashMap<>();
        int n= arr.length;

        for(int i=0; i<n; i++)
        {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        int ops=0;
        for(Integer key: map.keySet())
        {
            int freq= map.get(key);

            if(freq==1)
                return -1;
            else if(freq%3==0)
                ops+= freq/3;
            
            else if(freq%3==1)
                ops+= (freq-4)/3 + 2;
            
            else
                ops+= freq/3 + 1;
        }
        return ops;
    }
}