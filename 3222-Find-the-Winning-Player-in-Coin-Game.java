class Solution {
    public String winningPlayer(int x, int y) {
        int usedX= y/4;
        
        if(4*x <=y)
        {
            if(x%2==0)
                return "Bob";
            else
                return "Alice";
        }
        else
        {
            if((y/4)%2==0)
                return "Bob";
                
            return "Alice";
        }
    }
}