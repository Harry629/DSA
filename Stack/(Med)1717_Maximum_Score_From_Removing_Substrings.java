You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.

 

Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.
  
  
  
  class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        int score =0;
        String maxStr = (x>=y) ? "ab":"ba";
        String minStr = (x<y) ? "ab":"ba";

        //First pass
        String temp_first = removeSubstr(s, maxStr);
        int L = temp_first.length();
        int charRemoved = (n-L);
        score += (charRemoved/2)* Math.max(x,y);
        

        //second pass
        String temp_Sec = removeSubstr(temp_first, minStr);
        charRemoved= L- temp_Sec.length();
        score += (charRemoved/2) * Math.min(x,y);
        return score;
    }
    String removeSubstr(String s, String matchStr){
        Stack<Character> st = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == matchStr.charAt(1) && !st.isEmpty() && st.peek()== matchStr.charAt(0)){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        StringBuilder temp= new StringBuilder();
        while(!st.isEmpty()){
            temp.append(st.peek());
            st.pop();
        }
        return temp.reverse().toString();
    }
}
