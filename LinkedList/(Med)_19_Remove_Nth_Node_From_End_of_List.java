// Given the head of a linked list, remove the nth node from the end of the list and return its head.

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size =1;
        ListNode prev= head;
        while(prev.next != null && prev != null){
            size++;
            prev = prev.next;
        }
        prev = head;
        if(size == 1){
            return null;
        }
        if(n == size){
            head = head.next;
        }
        
        int m = size-n+1;
        for(int i=1;i<m-1;i++){
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
