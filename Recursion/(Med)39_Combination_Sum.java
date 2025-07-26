Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. 
You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        comb(n,0,candidates,target,ans,new ArrayList<>());
        return ans; 
    }
    public void comb(int n,int index,int[] arr,int target,List<List<Integer>> ans,List<Integer> curr){
        if(index==n || target==0){
            if(target==0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        if(arr[index]<= target){
            curr.add(arr[index]);
            comb(n,index,arr,target-arr[index],ans,curr);
            curr.remove(curr.size()-1);
        }
        comb(n,index+1,arr,target,ans,curr);
    }
}
