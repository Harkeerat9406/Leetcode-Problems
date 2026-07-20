class Solution {
    public boolean countPrefix(char t[], char s[])
    {
        int t1=0, s1=0, n= t.length;

        for(int i=0; i<n; i++)
        {
            if(s[i]=='1')
                s1++;
            
            if(t[i]== '1')
                t1++;

            if(t1>s1)
                return false;
        }
        return true;
    }

    public boolean[] transformStr(String s, String[] strs) {
        int s0=0, s1=0, slen= s.length();
        for(int i=0; i<slen; i++)
        {
            if(s.charAt(i) == '1')
                s1++;
            else
                s0++;
        }

        int idx=0;
        boolean ans[]= new boolean[strs.length];

        for(String t : strs)
        {
            char arr[]= t.toCharArray();
            int tlen= arr.length, count0=0, count1=0, mark=0;
            if(tlen!=slen)
            {
                ans[idx++]= false;
                continue;
            }

            for(int i=0; i<tlen; i++)
            {
                char ch= arr[i];
                if(ch == '1')
                    count1++;
                else if(ch == '0')
                    count0++;
                else
                    mark++;
            }
            int d0= s0-count0, d1= s1-count1;
            d0= d0>0 ? d0 : 0;
            d1= d1>0 ? d1 : 0;

            if(d1+d0 != mark)
            {
                ans[idx++]= false;
                continue;
            }

            int tempd0= d0, tempd1= d1, j=0;
            while(tempd0>0)
            {
                char ch= arr[j];
                if(ch=='?')
                {
                    arr[j]= '0';
                    tempd0--;
                }
                j++;
            }

            j=tlen-1;
            while(tempd1>0)
            {
                char ch= arr[j];
                if(ch=='?')
                {
                    arr[j]= '1';
                    tempd1--;
                }
                j--;
            }

            if(countPrefix(arr, s.toCharArray()))
                ans[idx++]= true;
            else
                ans[idx++]= false;
        }
        return ans;
    }
}