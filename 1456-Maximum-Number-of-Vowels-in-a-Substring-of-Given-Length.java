class Solution {
    public int maxVowels(String s, int k) {
        int n= s.length();
        int prefix[]= new int[n+1];
        prefix[0]= 0;
        String vow= "aeiou";
        
        for(int i=0; i<n; i++)
        {
            char ch= s.charAt(i);
            if(vow.indexOf(ch) != -1)
                prefix[i+1]= prefix[i]+1;
            else
                prefix[i+1]= prefix[i];
        }

        int i=0, j=i+k-1, max= 0;
        while(j<n)
        {
            max= Math.max(max, prefix[j+1]-prefix[i]);
            i++;
            j++;
        }
        return max;
    }
}