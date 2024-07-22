import java.util.*;
class Node{
    int data;
    Node next;
    Node(int num){
        data = num;
        next = null;
    }
}
public class Main{
    static void display(Node head){
        if(head==null){
            System.out.println("List is Empyt");
        }
        else{
            Node temp = head;
            while(temp!= null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
    static Node InsertAtBeg(int num,Node head){
        Node newNode = new Node(num);
        // if(head==null){
        //     head= newNode;
        // }else{
        newNode.next = head;
        head = newNode;
    // }
    return head;
    }    
	public static void main(String[] args) {
		Node head = null;
		while(true){
		    System.out.println("1. InsertAtBeg\n2. InsertAtEnd\n3. Display\n0. exit");
		    Scanner sc = new Scanner(System.in);
		    int choice = sc.nextInt();
		    if(choice==1){
		        int num = sc.nextInt();
		        head = InsertAtBeg(num,head);
		    }else if(choice ==3){
		        display(head);
		    }else if(choice ==0){
		        break;
		    }else{
		        System.out.println("Choose a valid option");
		    }
		}
	}
}