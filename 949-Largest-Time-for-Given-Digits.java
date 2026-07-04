class Solution {
    int n, max= Integer.MIN_VALUE;
    boolean used[];

    public void helper(int time, int digits, int arr[])
    {
        if(digits==2 && time>23)
            return;
        
        if(digits==3 && time>236)
            return;
        
        if(digits==4)
        {
            if(time<=2359)
                max= Math.max(max, time);
            return;
        }

        for(int i=0; i<n; i++)
        {
            if(used[i])
                continue;
            
            if(digits==2 && arr[i]>=6)
                continue;

            used[i]= true;
            helper(time*10+ arr[i], digits+1, arr);
            used[i]= false;
        }
    }

    public String largestTimeFromDigits(int[] arr) {
        n= arr.length;
        int time=0;
        used= new boolean[n];

        for(int i=0; i<n; i++)
        {
            if(arr[i]>2)
                continue;
            
            used[i]= true;
            helper(time*10 + arr[i], 1, arr);
            used[i]= false;
        }
        if(max==Integer.MIN_VALUE)
            return "";
        
        String t= Integer.toString(max);
        char c1, c2, c3, c4;
        if(max==0)
            return "00:00";
        if(max<10)
        {
            return "00:0"+t.charAt(0);
        }
        if(max<100)
        {
            return ("00:"+t.charAt(0))+t.charAt(1);
        }
        if(max<1000)
        {
            return ("0"+t.charAt(0))+(":"+t.charAt(1))+t.charAt(2);
        }
        t= t.charAt(0)+(t.charAt(1)+":"+t.charAt(2))+t.charAt(3);
        return t;
    }
}