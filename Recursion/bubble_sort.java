import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int[] arr= {3,2,5,4,1};
        sort(arr,arr.length-1,0);
        System.out.print(Arrays.toString(arr));
    }
    public static void sort(int[] arr,int r,int c){
        if(r==0){
            return;
        }
        if(c<r){
            if(arr[c]>arr[c+1]){
                int temp= arr[c];
                arr[c]= arr[c+1];
                arr[c+1] = temp;
            }
            sort(arr,r,c+1);
        }
        else{
            sort(arr,r-1,0);
        }
    } 
}
