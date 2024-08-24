class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.substring(0,n)+ s.substring(n+ part.length());
            int n = s.indexOf(part);
        }
        return s;
    }
}
