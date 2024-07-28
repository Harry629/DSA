// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace
// and initial word order.

class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder arrs = new StringBuilder();
        int a = arr.length;
        int i=0;
        while(a>0){
            StringBuilder arr2 = new StringBuilder();
            arr2.append(arr[i++]);
            arrs.append(arr2.reverse());
            if(a>1){
                arrs.append(" ");
            }
            a--;
        }
        return arrs.toString();
    }
}
