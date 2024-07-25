
import java.util.*;
class NodeBst{
    int data;
    NodeBst left;
    NodeBst right;
    NodeBst(int num){
        data=num;
        left = null;
        right = null;
    }
}
class BST{
    NodeBst insert(NodeBst root, int num){
        if(root==null){
            root = new NodeBst(num);
        }else if(num<root.data){
            root.left = insert(root.left,num);
        }else{
            root.right=insert(root.right,num);
        }
        return root;
    }
    void preorder(NodeBst root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    void inorder(NodeBst root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
}
public class BST_Main{
    public static void main(String[] args){
        NodeBst root=null;
        BST tree = new BST();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n1.Insert\n2.Inorder\n3.Preorder\n0.Exit");
            int choice=sc.nextInt();
            if(choice==1){
                System.out.print("Enter a num "+"into BST:");
                int num=sc.nextInt();
                root= tree.insert(root,num);
            }else if(choice==2){
                tree.inorder(root);
            }else if(choice==3){
                tree.preorder(root);
            }else if(choice==0){
                break;
            }else{
                System.out.println("Enter a valid choice");
            }
        }
    }
}

