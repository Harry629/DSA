Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

  class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, pref =1, suff =1;
        int n= nums.length;
        for(int i=0;i<n;i++){
            if(pref==0) pref =1;
            if(suff ==0) suff =1;
            pref *= nums[i];
            suff *= nums[n-i-1];
            max =Math.max(max, Math.max(pref, suff));
        }
        return max;
    }
}
