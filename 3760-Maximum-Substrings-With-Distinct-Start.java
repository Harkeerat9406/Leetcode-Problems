class Solution {
    public int maxDistinct(String s) {
        int freq[]= new int[26];
        int count=0, i=0, n= s.length();

        while(i<n)
        {
            int idx= s.charAt(i)-'a';
            
            if(freq[idx]==0)
            {
                count++;
                i++;
                freq[idx]++;
            }
            else
            {
                while(i<n && freq[s.charAt(i)-'a'] > 0)
                {
                    i++;
                }
            }
        }
        return count;
    }
}