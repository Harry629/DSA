// Given three integer arrays nums1, nums2, and nums3, return a distinct array containing all the values that are present
// in at least two out of the three arrays. You may return the values in any order.

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set3 = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for(int i:nums1){
            set1.add(i);
        }
        for(int i:nums2){
            if(set1.contains(i)){
                ans.add(i);
            }
            set2.add(i);
        }
        for(int i:nums3){
            if(set1.contains(i) || set2.contains(i)){
                ans.add(i);
            }
        }
        return new ArrayList<>(ans);
    }
}
