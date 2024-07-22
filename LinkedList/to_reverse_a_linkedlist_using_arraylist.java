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
    public ListNode reverseList(ListNode head) {
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
