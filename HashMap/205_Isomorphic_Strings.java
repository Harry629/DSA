// Given two strings s and t, determine if they are isomorphic.
// Two strings s and t are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving the order of characters. 
// No two characters may map to the same character, but a character may map to itself.

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!= t.length()){
            return false;
        }
        Map<Character,Character> hmS = new HashMap<>();
        Map<Character, Character> hmT = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char chS= s.charAt(i);
            char chT = t.charAt(i);
            if(hmS.containsKey(chS)){
                if(hmS.get(chS)!=chT){
                    return false;
                }
            }else{
                hmS.put(chS,chT);
            }
            if(hmT.containsKey(chT)){
                if(hmT.get(chT)!=chS){
                    return false;
                }
            }else{
                hmT.put(chT,chS);
            }
        }
        return true;
    }
}
}
