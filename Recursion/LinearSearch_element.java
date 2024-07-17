// to see if a target element is present in the array or not

class HelloWorld {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,7,54,8};
        System.out.print(linearSearch(arr,5,0));
    }
    public static boolean linearSearch(int[] arr,int target,int i){
        if(i==arr.length-1){
            if(arr[i]==target){
                return true;
            }else{
                return false;
            }
        }
        return (arr[i]==target || linearSearch(arr,target,i=i+1));
    }
}
