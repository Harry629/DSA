// to sort a given string according to alphabetical order:

class HelloWorld {
    public static void main(String[] args) {
        String str= "chaitanya";
        int[] arr = new int[26];
        for(int i=0;i<str.length();i++){
            arr[str.charAt(i)-'a']++;
        }
        StringBuilder strb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            while(arr[i]>0){
                strb.append((char)(i+'a'));
                arr[i]--;
            }
        }
        System.out.println(strb.toString());
    }
}
