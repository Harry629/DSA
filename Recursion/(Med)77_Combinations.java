Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.
Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        comb(1,k,n,new ArrayList<>(),res);
        return res;
    }
    public void comb(int index,int k, int n,List<Integer> temp, List<List<Integer>> res){
        if(k==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(index>n) return;
        temp.add(index);
        comb(index+1,k-1,n,temp,res);
        temp.remove(temp.size()-1);
        comb(index+1,k,n,temp,res);
    }
}
