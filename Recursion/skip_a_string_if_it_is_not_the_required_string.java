class HelloWorld {
    public static void main(String[] args) {
        
        System.out.println(skipabc("abcabcdeb"));
    }
    static String skipabc(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if(up.startsWith("abc") && !up.startsWith("abcde")){
            return skipabc(up.substring(3));
        }else{
            return ch+skipabc(up.substring(1));
        }
    }
}
