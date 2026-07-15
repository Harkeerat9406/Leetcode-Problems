class Solution {
    public String compressedString(String s) {
        int count=0, n= s.length();
        StringBuilder sb= new StringBuilder();
        char prev= s.charAt(0);

        for(int i=0; i<n; i++)
        {
            char ch= s.charAt(i);
            if(ch==prev)
            {
                count++;
                if(count==9)
                {
                    sb.append(count);
                    sb.append(ch);
                    count=0;
                    if(i!=n-1) prev= s.charAt(i+1);
                }
                continue;
            }
            else
            {
                sb.append(count);
                sb.append(prev);
                count=1;
                prev= ch;
            }
        }
        if(count!=0)
        {
            sb.append(count);
            sb.append(prev);
        }
        return new String(sb);
    }
}