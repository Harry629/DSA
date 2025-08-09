A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]

class Solution {
    public void nextPermutation(int[] nums) {
        int n= nums.length;
        int gola_index =-1;
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                gola_index=i-1;
                break;
            }
        }
        if(gola_index!=-1){
            int swap_index = gola_index;
            for(int j=n-1;j>=gola_index;j--){
                if(nums[j]>nums[gola_index]){
                    swap_index = j;
                    break;
                }
            }
            swap(nums,swap_index,gola_index);
        }
        reverseRange(nums, gola_index+1, n-1);
    }
    public void reverseRange(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
