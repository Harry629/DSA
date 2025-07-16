// You are given an integer array nums.
// A subsequence sub of nums with length x is called valid if it satisfies:

// (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
// Return the length of the longest valid subsequence of nums.

// A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;

        int counte =0;
        int counto = 0;
        int countparity =1;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                counte++;
            }else{
                counto++;
            }
        }
        int parity = nums[0]%2;
        for(int i=1;i<n;i++){
            int currparity = nums[i]%2;
            if(currparity != parity){
                countparity++;
                parity = currparity;
            }
        }
        return Math.max(Math.max(counte, counto), countparity);

    }
}
