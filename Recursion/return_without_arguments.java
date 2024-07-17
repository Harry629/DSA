// to add without arguments

import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,7,4,54,8,2};
        System.out.print(linearSearch(arr,2,0));
    }
    public static ArrayList linearSearch(int[] arr,int target,int i){
        ArrayList<Integer> arrl = new ArrayList<>();
        if(i==arr.length){
            return arrl;
        }
        if(arr[i]==target){
            arrl.add(i);
        }
        ArrayList<Integer> ansfromBelowCalls =(linearSearch(arr,target,i=i+1));
        arrl.addAll(ansfromBelowCalls);
        return arrl;
        
    
    }
}
