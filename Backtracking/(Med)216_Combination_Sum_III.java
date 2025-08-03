Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

  class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
         comb(1,k,n,0,new ArrayList<>(),res);
         return res;
    }
    public void comb(int i, int k, int n,int sum, List<Integer> temp, List<List<Integer>> res){
        if(sum > n || k<0 ) return;
        if(k==0){
            if(sum==n){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if(i==10){
            return;
        }
        sum += i;
        temp.add(i);
        comb(i+1,k-1,n,sum,temp, res);
        sum -= i;
        temp.remove(temp.size()-1);
        comb(i+1,k,n,sum,temp,res);
    }
}
