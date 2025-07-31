You are given an integer array nums of size n.
Consider a non-empty subarray from nums that has the maximum possible bitwise AND.
In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered.
Return the length of the longest such subarray.
  
The bitwise AND of an array is the bitwise AND of all the numbers in it.
A subarray is a contiguous sequence of elements within an array.

-----------------------------------------------------------------------------------------------------------
  --->> Here, as we know by the concept of and operator that the value (a & b) will be <= a and b;
hence here, we just have to find the max length of subarray having max value;



class Solution {
    public int longestSubarray(int[] nums) {
        int max=0;
        int res =0;
        int streak=0;
        for(int num: nums){
            if(num> max){
                max = num;
                res = 0;
                streak=0;
            }
            if(num == max){
                streak++;
            }else{
                streak=0;
            }
            res = Math.max(res, streak);
        }
        return res;
    }
}
