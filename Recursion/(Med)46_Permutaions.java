Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> hs = new HashSet<>();


    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        comb(nums,new ArrayList<Integer>(), n);
        return res;
    }


    public void comb(int[] nums,List<Integer> temp,int n){
        if(temp.size() == n){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++){
            if(!hs.contains(nums[i])){
                temp.add(nums[i]);
                hs.add(nums[i]);
                comb(nums,temp,n);
                temp.remove(temp.size()-1);
                hs.remove(nums[i]);
            }
            
        }
    }
}
