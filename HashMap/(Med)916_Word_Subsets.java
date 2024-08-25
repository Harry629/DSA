class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> arr = new ArrayList<String>();
        Map<Character, Integer> char2 = new HashMap<>();
        for(int i=0;i<words2.length;i++){
            char[] word= words2[i].toCharArray();
            Map<Character, Integer> char1 = new HashMap<>();
            for(char ch:word){
                char1.put(ch, char1.getOrDefault(ch,0)+1);
            }
            for(Map.Entry<Character,Integer> entry: char1.entrySet()){
                char ch = entry.getKey();
                int k = entry.getValue();
                char2.put(ch,Math.max(char2.getOrDefault(ch,0),k));
            }
        }
        for(int i=0;i<words1.length;i++){
            Map<Character, Integer> hm = new HashMap<>();
            char[] word = words1[i].toCharArray();
            for(char ch: word){
                hm.put(ch,hm.getOrDefault(ch,0)+1);
            }
            boolean flag = true;
            for(Map.Entry<Character, Integer> entry : char2.entrySet()){
                char key = entry.getKey();
                int value = entry.getValue();
                if(!hm.containsKey(key)){
                    flag = false;
                    break;
                }else{
                    int value1 = hm.get(key);
                    if(value <= value1){
                        flag = true;
                    }else{
                        flag = false;
                        break;
                    }
                }
                
            }
            if(flag){
                arr.add(words1[i]);
            }
            
        }
        return arr;
    }
}
