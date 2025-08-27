A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until 
reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.


  // =============================== Using Priority Queue ============================================
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n= mat.length;
        int m = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int key = i-j;
                hm.putIfAbsent(key,new PriorityQueue<>());
                hm.get(key).add(mat[i][j]);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j] = hm.get(i-j).poll();
            }
        }
        return mat;
    }
}


=============================== Using ArrayList =======================================================

  class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n= mat.length;
        int m = mat[0].length;
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int key = i-j;
                hm.putIfAbsent(key,new ArrayList<>());
                hm.get(key).add(mat[i][j]);
            }
        }
        for(List<Integer> l: hm.values()){
            Collections.sort(l);
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                List<Integer> list = hm.get(i-j);
                mat[i][j] = list.remove(list.size()-1);
            }
        }
        return mat;
    }
}
