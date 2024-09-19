// You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the
// largest sum.
// Return any such subsequence as an integer array of length k.
// Ans:-
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq= new PriorityQueue<int[]> ((a,b)->a[0]-b[0]);
        for(int i=0;i<nums.length;i++){
            pq.offer(new int[]{nums[i],i});
            if(pq.size()>k){
                pq.poll();
            }
        }
        Set<Integer> index = new HashSet<>();
        while(!pq.isEmpty()){
            int[] top= pq.poll();
            index.add(top[1]);
        }
        int[] arr = new int[k];
        int p= 0;
        for(int i=0;i<nums.length;i++){
            if(index.contains(i)){
                arr[p++]= nums[i];
            }
        }
        return arr;
    }
}
