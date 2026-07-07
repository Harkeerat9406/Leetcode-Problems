/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map= new HashMap<>();
        ListNode dummy= new ListNode();
        dummy.next= head;
        map.put(0, dummy);
        int sum=0;

        ListNode temp= head;
        while(temp!=null)
        {
            sum+= temp.val;
            ListNode last= map.getOrDefault(sum, null);
            if(last!=null)
            {
                int x= sum;
                ListNode rem= last.next;
                while(rem!=temp)
                {
                    x+= rem.val;
                    map.remove(x);
                    rem=rem.next;
                }
                last.next= temp.next;
            }
            if(last==null)
                map.put(sum, temp);
            temp= temp.next;
        }
        return dummy.next;
    }
}