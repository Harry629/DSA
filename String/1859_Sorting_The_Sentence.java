class Solution {
    public String sortSentence(String s) {
        String st[] = s.split(" "); // Split the string into an array of words
        String stra[] =new String[st.length];
        StringBuilder strb = new StringBuilder();
        for(int i=0; i<st.length; i++) {
            String str = st[i]; // Get each word
            int index = str.charAt(str.length()-1) - '0'; 
            stra[index-1]= str.substring(0,str.length()-1);
        }
        for(int i=0;i<st.length;i++){
            strb.append(stra[i]);
            if(i!=st.length-1){
                strb.append(" ");
            }
        }
        return strb.toString();
    }
}