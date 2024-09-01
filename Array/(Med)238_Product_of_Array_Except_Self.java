// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all
// the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] p = new int [n];
        int [] s = new int [n];
        p[0]=1;
        s[n-1]=1;
        for(int i=1;i<nums.length;i++){
            p[i] = p[i-1]* nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            s[i]= s[i+1]* nums[i+1];
        }
        int[] arr = new int[nums.length];
        for(int i=0;i<arr.length;i++){
            arr[i]= p[i]*s[i];
        }
        return arr;
    }
}
