// to return an ArrayList using recursion

import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,7,4,54,8};
        ArrayList<Integer> arrl = new ArrayList<>();
        System.out.print(linearSearch(arr,4,0,arrl));
    }
    public static ArrayList linearSearch(int[] arr,int target,int i,ArrayList<Integer> arrl){
        if(i==arr.length){
            return arrl;
        }
        if(arr[i]==target){
            arrl.add(i);
        }
        return (linearSearch(arr,target,i=i+1,arrl));
    
    }
}
