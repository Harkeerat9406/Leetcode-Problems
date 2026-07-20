class Solution {
    public int singleNumber(int[] arr) {
        int num=0, n= arr.length;

        for(int j=31; j>=0; j--)
        {
            int count=0;
            for(int i=0; i<n; i++)
            {
                if((arr[i] & (1<<j)) != 0)
                    count++;
            }

            if(count%3 !=0)
            {
                num= (num | (1<<j));
            }
        }
        return num;
    }
}