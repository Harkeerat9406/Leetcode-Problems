class Solution {
    public boolean doesAliceWin(String s) {
        int n= s.length(), count=0;
        String vow= "aeiou";

        for(int i=0; i<n; i++)
        {
            if(vow.indexOf(s.charAt(i)) !=-1)
                count++;
        }

        return count!=0;
    }
}