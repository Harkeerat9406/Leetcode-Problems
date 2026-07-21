class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n= s.length()+2, count1=0;
        char arr[]= new char[n];
        arr[0]= '1';
        arr[n-1]= '1';

        for(int i=1, j=0; i<n-1; i++, j++)
        {
            arr[i]= s.charAt(j);
            if(arr[i]=='1')
                count1++;
        }

        int i=0, max= count1;

        // skip 1s
        while(i<n && arr[i]=='1')
        {
            i++;
        }

        // count first segment of 0s
        int left0= 0;
        while(i<n && arr[i]=='0')
        {
            left0++;
            i++;
        }

        while(i<n)
        {            
            // traverse middle 1s
            while(i<n && arr[i]=='1')
            {
                i++;
            }
            
            // count second segment of 0s
            int right0= 0;
            while(i<n && arr[i]=='0')
            {
                right0++;
                i++;
            }

            if(right0!=0)
                max= Math.max(left0+right0+count1, max);
            
            left0= right0;
        }
        return max;
    }
}