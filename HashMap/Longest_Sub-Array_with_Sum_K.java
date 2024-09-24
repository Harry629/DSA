// Given an array arr containing n integers and an integer k. Your task is to find the length of the longest
// Sub-Array with the sum of the elements equal to the given value k.

// Examples:

// Input : n = 6, arr[] = {10, 5, 2, 7, 1, 9}, k = 15
// Output : 4
// Explanation: The sub-array is {5, 2, 7, 1}.

class Solution {
    public static int lenOfLongSubarr(int A[], int N, int K) {
        int sum =0;
        int ans=0;
        int a =0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int i=0;i<A.length;i++){
            sum += A[i];
            if(hm.containsKey(sum-K)){
                a = i- hm.get(sum-K); 
                ans = Math.max(ans, a);
            }
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }   
        }
        return ans;
    }
}
