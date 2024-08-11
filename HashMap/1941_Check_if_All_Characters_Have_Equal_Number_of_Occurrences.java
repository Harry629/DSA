class Solution {
    public boolean areOccurrencesEqual(String s) {
        char[] ch = s.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c:ch){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        int a = hm.get(ch[0]);
        for(Character c : hm.keySet()){
            if(hm.get(c)!= a){
                return false;
            }
        }
        return true;
    }
}
