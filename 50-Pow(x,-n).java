class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
            
        if(n==1)
            return x;
        else if(n==-1)
            return 1/x;
        
        double num= myPow(x, n/2);
        if(n%2==0)
            return num*num;
        else
        {
            if(n<0)
                return num * num * 1/x;
            else
                return num * num * x;
        }
    }
}