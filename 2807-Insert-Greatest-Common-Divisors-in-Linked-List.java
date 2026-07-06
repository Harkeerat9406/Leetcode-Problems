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
    public int findGcd(int prev, int curr)
    {
        int a= Math.max(prev, curr);
        int b= Math.min(prev, curr);

        while(b!=0)
        {
            int temp= a%b;
            a=b;
            b=temp;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next==null)
            return head;
        
        ListNode prev= head, curr= head.next;
        
        while(curr!=null)
        {
            ListNode gcd= new ListNode(findGcd(prev.val, curr.val));
            gcd.next= prev.next;
            prev.next= gcd;
            prev= curr;
            curr= curr.next;
        }
        return head;
    }
}