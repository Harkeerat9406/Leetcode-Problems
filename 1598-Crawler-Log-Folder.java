class Solution {
    public int minOperations(String[] arr) {
        Stack<Integer> stack= new Stack<>();
        int n= arr.length;
        for(int i=0; i<n; i++)
        {
            String s= arr[i];
            if(s.endsWith("../"))
            {
                if(stack.size() > 0)
                    stack.pop();
            }
            else if(s.endsWith("./"))
                continue;
            else
                stack.push(1);
        }
        return stack.size();
    }
}