class Solution {
    public long sumAndMultiply(int n) {
        int x=0, sum=0;
        int digits= 0;
        while(n>0)
        {
            int dig= n%10;
            sum+= dig;
            if(dig!=0)
                x= x+ dig * (int)Math.pow(10,digits++);
            
            n/=10;
        }
        return 1L*sum*x;
    }
}