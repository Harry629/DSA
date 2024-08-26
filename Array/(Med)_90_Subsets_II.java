// to eliminate duplicates from the subsets we just add the duplicate element in the last iterated subsets.
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return subsets(nums);
    }
    public List<List<Integer>> subsets(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<Integer>());
        int start =0, end =0;
        for(int j=0;j<arr.length;j++){
            start = 0;
            if(j>0 && arr[j]==arr[j-1]){
                start = end +1;
            }
            end = outer.size()-1;
            int n = outer.size();
            for(int i=start;i<n;i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(arr[j]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
