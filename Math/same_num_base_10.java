import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int n= 567;
        int n1=n;
        String str = Integer.toString(n);
        int len = str.length();
        int rem= 0;
        int num=0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(n>0){
            rem = n%10;
            num= repeat(rem,len);
            arr.add(num);
            n=n/10;
        }
        Collections.sort(arr);
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)>=n1){
                System.out.println(arr.get(i));
                break;
            }
        }
    }
    public static int repeat(int rem, int k){
        String num="";
        for(int i=0;i<k;i++){
            num= num+rem;
    }
    return Integer.parseInt(num);
}}