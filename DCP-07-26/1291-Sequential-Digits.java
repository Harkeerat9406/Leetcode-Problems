class Solution {
    List<Integer> list= new ArrayList<>();
    public void helper(int num, int low, int high, int prev)
    {
        if(num>=low && num<=high)
            list.add(num);
        
        if(prev==9)
            return;
        
        if((int)Math.log10(num)+1  == (int)Math.log10(high)+1)
            return;
        
        helper(num*10+(prev+1), low, high, prev+1);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        for(int i=1; i<=9; i++)
        {
            helper(i, low, high, i);
        }
        Collections.sort(list);
        return list;
    }
}