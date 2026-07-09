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
class Solution 
{
    public ListNode mergeList(ListNode head1, ListNode head2)
    {
        if(head1==null)
            return head2;
        else if(head2==null)
            return head1;
        
        if(head1.val<head2.val)
        {
            head1.next= mergeList(head1.next, head2);
            return head1;
        }
        else
        {
            head2.next= mergeList(head1, head2.next);
            return head2;
        }
    }

    public ListNode findMid(ListNode head)
    {
        ListNode slow= head, fast= head.next;

        while(fast!=null && fast.next!=null)
        {
            slow= slow.next;
            fast= fast.next.next;
        }
        return slow;
    }

    public ListNode mergeSort(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        
        ListNode mid= findMid(head);
        ListNode midNext= mid.next;
        mid.next= null;

        ListNode left= mergeSort(head);
        ListNode right= mergeSort(midNext);
        return mergeList(left, right);
    }

    public ListNode sortList(ListNode head) 
    {
        if(head==null || head.next==null)
            return head;

        return mergeSort(head);
    }
}