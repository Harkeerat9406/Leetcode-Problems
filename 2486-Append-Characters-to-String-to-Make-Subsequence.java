class Solution {
    public int appendCharacters(String s, String t) {
        int slen= s.length();
        int tlen= t.length();
        int i=0, j=0;
       
        while(i<slen && j<tlen)
        {
            if(s.charAt(i) == t.charAt(j))
            {
                j++;
            }
            i++;
        }

        if(j==tlen)
            return 0;
        else
            return tlen-j;
    }
}