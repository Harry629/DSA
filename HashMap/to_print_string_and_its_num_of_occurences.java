// print "aabbcc" --> "a2b2c2"

import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        String s = "aabbcc";
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        Map<Character, Integer> hm = new HashMap<>();
        for(char c:ch){
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character, Integer> entry: hm.entrySet()){
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }
        
        System.out.println(sb.toString());
    }
}
