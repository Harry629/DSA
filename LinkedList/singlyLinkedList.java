package Practice;

public class Ll{

    private Node head;
    private Node tail;

    private int size;
    public Ll(){
        this.size=0;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail==null){
            tail = head;
        }
        size += 1;
    }
    public void insertLast(int val){
        if(tail==  null){
            insertFirst(val);
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    public void insert(int val, int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i=1;i<index;i++){
            temp= temp.next;
        }
        Node temp1 = temp.next;
        Node node = new Node(val);  // or  Node node = new Node(val, temp.next);
        temp.next = node;
        node.next = temp1;
        size++;
    }
    public int deleteFirst(){
        int val = head.val;
        head = head.next;
        if(head==null){
            tail= null;
        }
        size--;
        return val;
    }
    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int val = tail.val;
        tail = secondLast;
        tail.next = null;
        return val;
    }
    public int delete(int index){
        if(index==0){
            deleteFirst();
        }
        if(index==size-1){
            deleteLast();
        }
        Node prev = get(index-1);
        int val= prev.next.val;
        prev.next = prev.next.next;
        return val;
    }
    public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.val == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public Node get(int index){
        Node node = head;
        for(int i=0;i<index;i++){
            node = node.next;
        }
        return node;
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }
    private class Node{
        int val;
        Node next;
        public Node(int value){
            this.val= value;
        }
        public Node(int value, Node next){
            this.val = value;
            this.next = next;
        }
    }
}

package Practice;

public class Main {
    public static void main(String[] args) {
        Ll list = new Ll();
        list.insertFirst(3);
        list.insertFirst(8);
        list.insertFirst(9);
        list.insertFirst(32);
        list.insertLast(33);
        list.insertFirst(31);
        list.insert(33,2);
        list.display();
//        System.out.println(list.delete(2));
//        list.display();
        System.out.println(list.find(33));
    }
}
