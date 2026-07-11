class Solution {
    int max= 0;

    public boolean allSatisfy(int freq[], int k)
    {
        for(int i=0; i<26; i++)
        {
            if(freq[i]!= 0 && freq[i]<k)
                return false;
        }
        return true;
    }

    public void findSubstring(char arr[], int n, int k, int unique)
    {
        int freq[]= new int[26];
        int i=0, j=0, distinct=0;

        while(j<n)
        {
            char ch= arr[j];
            freq[ch-'a']++;

            if(freq[ch -'a'] == 1)
                distinct++;

            while(distinct > unique)   // reset window to curr index
            {
                char c= arr[i];
                freq[c-'a']--;
                if(freq[c-'a']==0)
                    distinct--;
                i++;
            }
            if(allSatisfy(freq, k))
                max= Math.max(max, j-i+1);
            j++;
        }
    }

    public int longestSubstring(String s, int k) {
        int n= s.length();
        char arr[]= s.toCharArray();
        for(int i=1; i<=26; i++)
        {
            findSubstring(arr, n, k, i);
        }
        return max;
    }
}