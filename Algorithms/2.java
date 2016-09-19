/**
 * 2. Add Two Numbers
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
 
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
 
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode first = new ListNode(0);
        ListNode now = first;
        ListNode n1 = l1, n2 = l2;
        int carry = 0;
        while(n1 != null || n2 != null || carry != 0) {
            int sum = carry;
            if(n1 != null) {
                sum += n1.val;
                n1 = n1.next;
            }
            if(n2 != null) {
                sum += n2.val;
                n2 = n2.next;
            }

            carry = sum / 10;
            now.next = new ListNode(sum % 10);
            now = now.next;
        }
        return first.next;
    }
}
