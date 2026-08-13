// You are maintaining a project that has n methods numbered from 0 to n - 1.
// You are given two integers n and k, and a 2D integer array invocations, where invocations[i] = [ai, bi] indicates that method ai invokes method bi.
// There is a known bug in method k. Method k, along with any method invoked by it, either directly or indirectly, are considered suspicious and we aim to remove them.
// A group of methods can only be removed if no method outside the group invokes any methods within it.
// Return an array containing all the remaining methods after removing all the suspicious methods. You may return the answer in any order. If it is not possible to
// remove all the suspicious methods, none should be removed.

---------------sol----------------------------------  
  class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int[] priority = new int[n];
        for(int i=0;i<invocations.length;i++){
            priority[invocations[i][1]]++;
        }
        boolean[] bug= new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        bug[k]=true;
        ArrayList<ArrayList<Integer>> mat = createGraph(n, invocations);
        while(!q.isEmpty()){
            int a = q.poll();
            for(int i:mat.get(a)){
                priority[i]--;
                if(!bug[i]){
                    q.add(i);
                    bug[i]=true;
                }
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(priority[i]==0 && bug[i]) continue;
            if(!bug[i]) answer.add(i);
            if(priority[i]!=0 && bug[i]){
                for(int j=0;j<n;j++){
                    temp.add(j);
                }
                return temp;
            }
        }
        return answer;

    }
    public ArrayList<ArrayList<Integer>> createGraph(int n,int[][] edge){
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for(int i=0;i<n;i++){
            mat.add(new ArrayList<>());
        }
        for(int i=0;i<edge.length;i++){
            int u = edge[i][0];
            int v = edge[i][1];
            mat.get(u).add(v);
        }
        return mat;
    }
}
