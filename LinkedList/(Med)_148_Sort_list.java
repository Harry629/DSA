// Given the head of a linked list, return the list after sorting it in ascending order.

Solution {
    public ListNode sortList(ListNode head) {
        head = sortLL(head);
        return head;
    }
    public ListNode merged(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1 != null){
            temp.next = list1;
        }else{
            temp.next = list2;
        }
        return dummy.next;
    }
    public ListNode findMiddle(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode sortLL(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle= findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;
        left = sortLL(left);
        right = sortLL(right);
        return merged(left, right);
    }

}