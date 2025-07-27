Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.
Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int n=0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        comb(0,n,target,candidates,res,new ArrayList<>());
        return res;
    }
    public void comb(int index,int n,int target,int[] arr,List<List<Integer>> res, List<Integer> temp){
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<n;i++){
            if(i> index && arr[i]== arr[i-1]) continue;
            if(arr[i]>target) break;
            temp.add(arr[i]);
            comb(i+1,n,target-arr[i],arr,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}


---------------------------------------- Without using for loop --------------------------

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int n=0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        comb(0,n,target,candidates,res,new ArrayList<>());
        return res;
    }
    public void comb(int index,int n,int target,int[] arr,List<List<Integer>> res, List<Integer> temp){
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(index>=n || arr[index]>target) return;
        temp.add(arr[index]);
        comb(index+1,n, target-arr[index],arr,res,temp);
        temp.remove(temp.size()-1);
        int next = index+1;
        while(next <n && arr[next]== arr[index]) next++;
        comb(next,n,target,arr,res,temp);
    }
}
