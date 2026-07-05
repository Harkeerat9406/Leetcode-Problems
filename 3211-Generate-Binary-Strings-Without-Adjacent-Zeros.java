class Solution {
    List<String> ans= new ArrayList<>();

    public void helper(int len, char prev, StringBuilder sb, int n)
    {
        if(len==n)
        {
            ans.add(new String(sb));
            return;
        }

        if(prev == 'a')
        {
            sb.append('0');
            helper(len+1, '0', sb, n);

            sb.setLength(0);
            sb.append('1');
            helper(len+1, '1', sb, n);
            return;
        }

        if(prev=='0')
        {
            sb.append('1');
            helper(len+1, '1', sb, n);
        }
        else
        {
            sb.append('0');
            helper(len+1, '0', sb, n);
            sb.setLength(len);

            sb.append('1');
            helper(len+1, '1', sb, n);
        }
    }
    
    public List<String> validStrings(int n) {
        helper(0, 'a', new StringBuilder(), n);
        return ans;
    }
}