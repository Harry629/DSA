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
    static Node InsertAtEnd(int num, Node head){
        Node newNode = new Node(num);
        if(head==null){
            newNode.next=head;
            head = newNode;
        }else{
            Node temp = head;
            while(temp.next!= null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return head;
    }
    static Node removeFirst(Node head){
        if(head==null){
            System.out.println("List is empty");
        }else{
            System.out.println(head.data);
            Node temp = head;
            head= head.next;
            temp.next=null;
        }
        display(head);
        return head;
    }
    static Node removeLast(Node head){
        if(head==null){
            System.out.println("List is Empty");
        }else if(head.next==null){
            System.out.println(head.data);
            head= null;
        }else{
            Node temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        System.out.println(temp.next.data);
        temp.next = null;
        display(head);
    }
    return head;
    }
    static Node insertAtPos(int num,int pos,Node head){
        Node newnode = new Node(num);
        if(pos<=0){
            System.out.println("Invalid position");
        }else if(pos==1 || head==null){
            newnode.next = head;
            head = newnode;
        }
        else{
            Node temp= head;
            for(int i=1;i<pos-2;i++){
                temp = temp.next;
                if(temp==null){
                    System.out.println("Position beyond the list");
                    return head;
                }
            }
            newnode.next = temp.next;
            temp.next = newnode;
        }
        return head;
    }
    static Node deleteAtPos(int pos, Node head){
        if(head==null){
            System.out.println("List is Empty");
        }else if(pos<=0){
            System.out.println("Invalid Position");
        }else if(pos==1){
                System.out.println("The deleted element id"+head.data);
                head = head.next;
        }else{
            Node last = head;
            Node last2= head;
            for(int i=1;i<=pos-1;i++){
                last2 =last;
                last= last.next;
                if(last==null){
                    System.out.println("Position beyond the list");
                    return head;
                }
            }
            last2.next = last.next;
            System.out.print("The deleted element is"+last.data);
            last.next = null;
        }
        return head;
    }
    
	public static void main(String[] args) {
		Node head = null;
		while(true){
		    System.out.println("1. InsertAtBeg\n2. InsertAtEnd\n3. Display\n4. RemoveFirst\n5. removeLast\n6. InsertAtPos\n7. deleteAtPos\n0. exit");
		    Scanner sc = new Scanner(System.in);
		    int choice = sc.nextInt();
		    if(choice==1){
		        int num = sc.nextInt();
		        head = InsertAtBeg(num,head);
		    }else if(choice==2){
		        int num = sc.nextInt();
		        head = InsertAtEnd(num,head);
		    }
		    else if(choice ==3){
		        display(head);
		    }else if(choice==4){
		        head=removeFirst(head);
		    }else if(choice==5){
		        head= removeLast(head);    
		    }else if(choice==6){
		        int num = sc.nextInt();
		        System.out.print("Enter Position");
		        int pos= sc.nextInt();
		        head = insertAtPos(num,pos,head);
		    }else if(choice==7){
		        int pos = sc.nextInt();
		        head = deleteAtPos(pos,head);
		    }else if(choice ==0){
		        break;
		    }else{
		        System.out.println("Choose a valid option");
		    }
		}
	}
}
