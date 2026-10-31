// Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements 
// are emails representing emails of the account.

// Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if 
// two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but 
// all of their accounts definitely have the same name.

// After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails
// in sorted order. The accounts themselves can be returned in any order.

// ----------------------------------------------- sol --------------------------------------------

class Solution {
    int n;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String s = accounts.get(i).get(j);
                if(!hm.containsKey(s)) {
                    hm.put(s, i);
                }else{
                    ds.union(hm.get(s),i);
                }
            }
        }
        List<List<String>> listAcc = new ArrayList<>();
        for(int i=0;i<n;i++){
            listAcc.add(new ArrayList<>());
        }
        for(Map.Entry<String,Integer> entry: hm.entrySet()){
            listAcc.get(ds.findP(entry.getValue())).add(entry.getKey());
        }
        for(List ll : listAcc){
            Collections.sort(ll);
        }
        List<List<String>> ans = new ArrayList<>();
        int count=0;
        for(int i=0;i<n;i++){
            if(listAcc.get(i).size()>0){
                ans.add(new ArrayList<>());
                ans.get(count).add(accounts.get(i).get(0));
                ans.get(count).addAll(listAcc.get(i));
                count++;
            }
        }
        return ans;
    }
    class DisjointSet{
        int[] rank = new int[n];
        int[] parent = new int[n];
        public DisjointSet(int node){
            for(int i=0;i<node;i++){
                rank[i]=0;
                parent[i]=i;
            }
        }
        public int findP(int node){
            if(node == parent[node]){
                return node;
            }
            int parentU = findP(parent[node]);
            parent[node] = parentU;
            return parentU;
        }
        public void union(int u, int v){
            int Pu = findP(u);
            int Pv = findP(v);
            if(Pu == Pv) return;
            if(rank[Pu] < rank[Pv]){
                parent[Pu] = Pv;
            }else if(rank[Pv] < rank[Pu]){
                parent[Pv] = Pu;
            }else{
                parent[Pv] = Pu;
                int rankU = rank[Pu];
                rank[Pu] = rankU +1;
            }
        }
    }
}
