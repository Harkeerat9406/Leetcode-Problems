class Solution {
    public boolean checkValidString(String s) {
        int open=0, close=0;
        int n= s.length();

        for(int i=0; i<n; i++)
        {
            char ch= s.charAt(i);

            if(ch=='(' || ch=='*')
                open++;
            else
                open--;
            
            if(open<0)
                return false;
        }

        for(int i=n-1; i>=0; i--)
        {
            char ch= s.charAt(i);

            if(ch==')' || ch=='*')
                close++;
            else
                close--;
            
            if(close<0)
                return false;
        }
        return true;
    }
}