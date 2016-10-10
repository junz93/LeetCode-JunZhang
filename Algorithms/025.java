/**
 * 25. Reverse Nodes in k-Group
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = head;
        for(int i = 0; i < k-1; i++)
            res = res.next;
        
        
        return res;
    }
}
