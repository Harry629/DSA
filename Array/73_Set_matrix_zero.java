// 73. Set Matrix Zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        int k=0;
        ArrayList<Integer> arr2 = findzero(matrix);
        while(k<arr2.size()){
            for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(k%2==0 && arr2.get(k)<=i){
                    matrix[arr2.get(k)][j]=0;
                }else if(k%2!=0 && arr2.get(k)<=j){
                    matrix[i][arr2.get(k)]=0;
                }
            }
        }
        k++;
        }
    }
    public ArrayList findzero(int[][] arr){
        ArrayList<Integer> arr1=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==0){
                    arr1.add(i);
                    arr1.add(j);
                }
            }
        }
        return arr1;
    }
}
