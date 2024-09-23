// Given an array of integers nums and an integer k, return the total number of subarrays whose
// sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

// Example 1:

// Input: nums = [1,1,1], k = 2
// Output: 2


class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int ans =0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(hm.containsKey(sum-k)){
                ans += hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
