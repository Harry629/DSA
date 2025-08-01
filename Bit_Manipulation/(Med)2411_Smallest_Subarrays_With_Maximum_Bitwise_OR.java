You are given a 0-indexed array nums of length n, consisting of non-negative integers. For each index i from 0 to n - 1, you must determine the size of the minimum 
sized non-empty subarray of nums starting at i (inclusive) that has the maximum possible bitwise OR.
In other words, let Bij be the bitwise OR of the subarray nums[i...j]. You need to find the smallest subarray starting at i, such that bitwise OR of this subarray is
equal to max(Bik) where i <= k <= n - 1.
The bitwise OR of an array is the bitwise OR of all the numbers in it.
Return an integer array answer of size n where answer[i] is the length of the minimum sized subarray starting at i with maximum bitwise OR.
A subarray is a contiguous non-empty sequence of elements within an array.

Soln---------------------------------------------------------------------  
class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] setBit = new int[32];
        Arrays.fill(setBit,-1);
        int[] res = new int[n];
        for(int i=n-1;i>=0;i--){
            int endIdx = i;
            for(int j=0;j<32;j++){
                if((nums[i] & (1<<j))==0){ // if jth bit is not set
                    if(setBit[j]!=-1){
                        endIdx = Math.max(setBit[j],endIdx);
                    }
                }else{
                    setBit[j]=i;
                }
            }
            res[i] = endIdx - i +1;
        }
        return res;
    }
}
