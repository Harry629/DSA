
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        mergeSortInPlace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSortInPlace(int[] arr,int s,int e){
        if((e-s)== 1){
            return ;
        }
        int mid = (s+e)/2;
        
        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid,e);
        
        mergeInPlace(arr, s , mid, e);
    }
    static void mergeInPlace(int[] arr, int s,int mid, int e){
        int[] mix = new int[e-s];
        int i=s,j=mid,k=0;
        
        while(i<mid && j<e){
            if(arr[i]< arr[j]){
                mix[k]= arr[i++];
            } else{
                mix[k]= arr[j++];
            }
            k++;
        }
        // it may be possible one of the array is not complete
        // add all the remaining elements in the array
        while(i<mid){
            mix[k]= arr[i++];
            k++;
        }
        while(j<e){
            mix[k]= arr[j++];
            k++;
        }
        
        for(int l=0;l<mix.length;l++){
            arr[s+l]= mix[l];
        }
        
    }
}













