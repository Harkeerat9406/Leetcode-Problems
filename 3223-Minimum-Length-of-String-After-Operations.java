class Solution {
    public int minimumLength(String s) {
        int freq[]= new int[26];
        int len= 0, slen= s.length();

        for(int i=0; i<slen; i++)
        {
            freq[s.charAt(i)-'a']++;
        }

        for(int i: freq)
        {
            if(i>0 && i%2==0)
                len+= 2;
            else if(i>0 && i%2!=0)
                len++;
        }
        return len;
    }
}