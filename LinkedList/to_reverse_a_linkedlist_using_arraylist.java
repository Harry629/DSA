import java.util.*;
class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode reverseList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            arr.add(temp.val);
            temp=temp.next;
        }
        ListNode temp2 = new ListNode(-1);
        ListNode temp3 = temp2;
        for(int i=arr.size()-1;i>=0;i--){
            temp3.next = new ListNode(arr.get(i));
            temp3 = temp3.next;
        }
        return temp2.next;
    }
    public static void main(String[] args){
        ListNode ll = new ListNode(1);
        ll.next= new ListNode(2);
        ll.next.next = new ListNode(3);
        ll.next.next.next = new ListNode(4);
        ll.next.next.next.next = new ListNode(5);
        ll.next.next.next.next.next = new ListNode(6);
        ListNode ll1 = reverseList(ll);
        while(ll1!= null){
            System.out.println(ll1.val);
            ll1= ll1.next;
        }
    }
    
}
