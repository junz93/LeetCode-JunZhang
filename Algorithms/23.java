class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
            
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2)
            {
                if(n1.val < n2.val)
                    return -1;
                if(n1.val > n2.val)
                    return 1;
                return 0;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode rear = dummy;
        for(int i = 0; i < lists.length; i++)
            if(lists[i] != null)
                pq.add(lists[i]);

        while(!pq.isEmpty())
        {
            ListNode node = pq.poll();
            rear.next = new ListNode(node.val);
            rear = rear.next;
            if(node.next != null)
                pq.add(node.next);
        }
        
        return dummy.next;
    }
}
