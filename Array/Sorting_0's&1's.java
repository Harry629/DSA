import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
    int[] arr = {1,0,1,0,0,1,0,1,0};
    int i=0,j=arr.length-1;
    while(i<=j){
        if(arr[i]==0){
            i++;
        }else if(arr[j]==1){
            j--;
        }else{
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    for(int k:arr){
        System.out.print(k);
    }
    
    
    }
    public static void swap(int[] arr,int i,int j){
        int temp=0;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}