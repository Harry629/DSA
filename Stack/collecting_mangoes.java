// One day after storm Mina went to pick up mangoes in the garden with a basket. She began to pick up mangoes from the garden. And if she wants, she can throw away the last picked up mango from the basket. In this way, Mina kept picking up mangoes. She brought you with her to keep track of the biggest size of mango in the basket at that time. At any moment Mina can ask you about the biggest size of mango. Your job is to help Mina.

// Since you are a good programmer, so you write a program by which you are easily able to answer the question of Mina. During picking up mangoes, Mina can have 3 types of question/instruction for you.

// Type 1: Put an "x" size mango in the basket, which is picked up form garden.

// Type 2: Throw out last picked up mango.

// Type 3: Ask for the biggest mango size in the basket at that moment.


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        sc.nextLine();  // Consume newline after reading t
        int a = 1;  // Initialize case counter

        while (t-- > 0) {
            Stack<Integer> st = new Stack<>();
            int n = sc.nextInt();
            sc.nextLine();  // Consume newline after reading n
            int max = 0;
            
            System.out.println("Case " + a++ + ":");

            while (n-- > 0) {
                String command = sc.next();

                if (command.equals("A")) {
                    int an = sc.nextInt();
                    sc.nextLine();  // Consume newline after reading an
                    st.push(an);
                    if (an > max) {
                        max = an;
                    }
                } else if (command.equals("R")) {
                    if (!st.isEmpty()) {
                        int removed = st.pop();
                        if (removed == max) {
                            max = findNewMax(st);
                        }
                    }
                } else if (command.equals("Q")) {
                    if (st.isEmpty()) {
                        System.out.println("Empty");
                    } else {
                        System.out.println(max);
                    }
                }
            }
        }
        sc.close();
    }

    public static int findNewMax(Stack<Integer> st) {
        int newMax = Integer.MIN_VALUE;
        for (int num : st) {
            if (num > newMax) {
                newMax = num;
            }
        }
        return newMax;
    }
}
