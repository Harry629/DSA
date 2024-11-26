package Practice;

public class DoublyLl {
    Node head;
//    Node tail;
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
//        if(tail== null){
//            tail = head;
//        }
    }
//    public void insertLast(int val){    // with using tail
//        if(tail == null){
//            insertFirst(val);
//            return;
//        }
//        Node node = new Node(val);
//        tail.next = node;
//        node.prev = tail;
//        tail = node;
//    }
    public void insertLast(int val){
        if(head == null){
            insertFirst(val);
            return;
        }
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        Node node = new Node(val);
        last.next = node;
        node.prev = last;
    }
    public void insert(int after, int val){
        Node p = find(after);
        if(p == null){
            System.out.println("does not exist");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null){
            node.next.prev = node;
        }
    }
    public Node find(int val){
        Node node = head;
        while(node != null){
            if(node.val == val){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public void display(){
        Node node = head;
        Node last = null;
        while(node!=null){
            System.out.print(node.val + "-> ");
            last = node;
            node= node.next;
        }
        System.out.print("End");
        System.out.println();
        System.out.println("Print to rev");
        while(last!= null){
            System.out.print(last.val + "->");
            last = last.prev;
        }
        System.out.print("Start");
    }

    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}

