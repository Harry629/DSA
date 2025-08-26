Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

  class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer,List<Integer>> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int key = i+j;
                hm.putIfAbsent(key,new ArrayList<>());
                hm.get(key).add(mat[i][j]);
            }
        }
        List<Integer> result = new ArrayList<>();
        boolean flip = true;
        for(int i=0;i<= m+n-2;i++){
            List<Integer> diagonal = hm.get(i);
            if(diagonal == null) continue;
            if(flip){
                Collections.reverse(diagonal);
            }
            result.addAll(diagonal);
            flip = !flip;
        }
        int[] arr = new int[result.size()];
        for(int i=0;i< arr.length;i++){
            arr[i] = result.get(i);
        }
        return arr;
    }
}
