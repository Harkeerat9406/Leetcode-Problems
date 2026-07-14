class Solution {
    public String breakPalindrome(String s) {
        int n= s.length();
        if(n==1)
            return "";

        StringBuilder sb= new StringBuilder(s);

        for(int i=0; i<n/2; i++)
        {
            if(sb.charAt(i)!='a')
            {
                sb.setCharAt(i, 'a');
                return new String(sb);
            }
        }

        sb.setCharAt(n-1, 'b');
        return new String(sb);
    }
}