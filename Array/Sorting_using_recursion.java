// to return if an array is sorted or not

class HelloWorld {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,7,54,8};
        int i=0;
        System.out.print(sort(arr,i));
    }
    public static boolean sort(int[] arr,int i){
        if(i==arr.length-1){
            return true;
        }
        return ((arr[i]<arr[i+1]) && sort(arr,i+1));
    }
}
