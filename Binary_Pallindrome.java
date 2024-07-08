import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder str = new StringBuilder();
        while(n>0){
            int rem = n%2;
            str.append(rem);
            n = n/2;
        }
        String arr1 = str.toString();
        String arr = str.reverse().toString();
        System.out.println(arr);
        // System.out.println(isPalindrome(arr));
        if(arr1.equals(arr)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        
    }
}
