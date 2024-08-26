class HelloWorld {
    public static void main(String[] args) {
        String str = "a10b24c3d6";
        char[] ch = str.toCharArray();
        for(char c:ch){
            System.out.print(c+" ");
        }
        StringBuilder strb = new StringBuilder();
        int i=0;
        System.out.println();
        while(i<str.length()){
            char c = ch[i];
            i++;
            int count =0;
            while(i<str.length() && Character.isDigit(ch[i])){
                count = count*10 + (ch[i]-'0');
                i++;
            }
            for(int j=0;j<count;j++){
                strb.append(c);
                strb.append(" ");
            }
        }
        System.out.println(strb);
    }
}
