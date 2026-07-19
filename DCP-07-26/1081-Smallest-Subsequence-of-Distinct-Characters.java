class Solution {
    public String smallestSubsequence(String s) {
        int lastSeen[]= new int[26];
        boolean used[]= new boolean[26];
        Arrays.fill(used, false);
        Arrays.fill(lastSeen, -1);

        Stack<Character> stack= new Stack<>();

        for(int i=0; i<s.length(); i++)
        {
            char ch= s.charAt(i);
            lastSeen[ch-'a']= i;
        }

        for(int i=0; i<s.length(); i++)
        {
            char ch= s.charAt(i);
            
            if(!used[ch-'a'])
            {
                while(!stack.isEmpty() && stack.peek()>ch && lastSeen[stack.peek()-'a'] > i)
                {
                    used[stack.peek()-'a']= false;
                    stack.pop();   
                }
                
                stack.push(ch);
                used[ch-'a']= true;
            }

    
        }

        StringBuilder sb= new StringBuilder();

        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}