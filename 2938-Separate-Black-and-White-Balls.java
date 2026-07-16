class Solution {
    public long minimumSteps(String s) {
        long ones= 0, ops= 0;

        for(char ch: s.toCharArray())
        {
            if(ch=='1')
                ones++;
            else
                ops+= ones;
        }
        return ops;
    } 
}