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

public class Main {
    public static void main(String[] args) {
        Ll list = new Ll();
        list.insertFirst(3);
        list.insertFirst(8);
        list.insertFirst(9);
        list.insertFirst(32);
        list.display();
    }
}
