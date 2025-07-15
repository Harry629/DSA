// A word is considered valid if:

// It contains a minimum of 3 characters.
// It contains only digits (0-9), and English letters (uppercase and lowercase).
// It includes at least one vowel.
// It includes at least one consonant.
// You are given a string word.

// Return true if word is valid, otherwise, return false.

// ------------------ here we are using "aeiouAEIOU".indexOf(ch) to check if a certain char is vowel or not ------------------------------------------ 
class Solution {
    public boolean isValid(String w) {
        int n = w.length();
        if(n<3){
            return false;
        }
        int vowels =0, cons =0;
        for(char ch : w.toCharArray()){
            if(Character.isLetter(ch)){
                if("aeiouAEIOU".indexOf(ch) != -1){
                    vowels++;
                }else{
                    cons++;
                }
            } else if (!Character.isDigit(ch)){
                return false;
            }
        }
        return vowels >=1 && cons >= 1;
    }
}
