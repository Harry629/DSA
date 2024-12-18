// You are given the head of a singly linked-list. The list can be represented as:
// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) { 
            return;
        }
        
        ListNode mid = midNode(head);
        
        
        ListNode hs = reverseList(mid);
        
        
        ListNode hf = head;
        while (hf != null && hs != null) {
            ListNode temp1 = hf.next; 
            ListNode temp2 = hs.next; 
            
            hf.next = hs; 
            hs.next = temp1;
            
            hf = temp1; 
            hs = temp2; 
        }
        
        
        if (hf != null) {
            hf.next = null;
        }
    }

    
    public ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next; 
            head.next = prev;          
            prev = head;               
            head = next;               
        }
        return prev;
    }
}
