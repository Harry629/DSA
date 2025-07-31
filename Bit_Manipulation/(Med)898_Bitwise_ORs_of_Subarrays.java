Given an integer array arr, return the number of distinct bitwise ORs of all the non-empty subarrays of arr.
The bitwise OR of a subarray is the bitwise OR of each integer in the subarray. The bitwise OR of a subarray of one integer is that integer.
A subarray is a contiguous non-empty sequence of elements within an array.

Example:
Input: arr = [1,1,2]
Output: 3
Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
These yield the results 1, 1, 2, 1, 3, 3.
There are 3 unique values, so the answer is 3.
----------------------------------------------------------------------------------
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();
        
        for(int i=0;i<arr.length;i++){
            HashSet<Integer> curr = new HashSet<>();
            for(int a: prev){
                curr.add(a | arr[i]);
                result.add(a | arr[i]);
            }
            curr.add(arr[i]);
            result.add(arr[i]);
            prev = curr;
        }
        return result.size();
    }
}
