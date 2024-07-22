
import java.util.*;
class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode middle = mid(head);
        ListNode t= middle.next;
        middle.next = null;
        ListNode u=reverse(t);
        while(head!=null && u!=null){
            if(head.val!=u.val){
                return false;
            }
            head= head.next;
            u = u.next;
        }
        return true;
    }
    public static ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode reverse(ListNode head){
        ListNode current= head;
        ListNode next = null;
        ListNode prev = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev= current;
            current = next;
        }
        return prev;
    }
    
public static void main(String[] args){
    ListNode ll = new ListNode(1);
    ll.next= new ListNode(2);
    ll.next.next = new ListNode(3);
    ll.next.next.next = new ListNode(3);
    ll.next.next.next.next = new ListNode(2);
    ll.next.next.next.next.next = new ListNode(1);
    System.out.println(isPalindrome(ll));
}
}
    
