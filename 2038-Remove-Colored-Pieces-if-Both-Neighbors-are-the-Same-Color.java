class Solution {
    public boolean winnerOfGame(String s) {
        int a=0, b=0, currA=0, currB=0;
        int n= s.length();

        for(int i=0; i<n; i++)
        {
            char ch= s.charAt(i);

            if(ch=='A')
            {
                b+= currB > 2 ? currB-2 : 0;
                currB= 0;
                currA++;
            }
            else
            {
                a+= currA > 2 ? currA-2 : 0;
                currA= 0;
                currB++;
            }
        }
        b+= currB > 2 ? currB-2 : 0;
        a+= currA > 2 ? currA-2 : 0;
        
        if(a > b)
            return true;
        else
            return false;
    }
}