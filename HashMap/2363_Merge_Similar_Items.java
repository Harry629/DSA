// to convert a hashmap into a 2d arraylist and sort the arraylist accordingly

class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<items1.length;i++){
            hm.put(items1[i][0],items1[i][1]);
        }
        for(int i=0;i<items2.length;i++){
            if(hm.containsKey(items2[i][0])){
                hm.put(items2[i][0],hm.get(items2[i][0])+items2[i][1]);
            }
            else{
                hm.put(items2[i][0],items2[i][1]);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            List<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            result.add(list);
        }
        Collections.sort(result, Comparator.comparingInt(a -> a.get(0)));
        return result;
    }
}
