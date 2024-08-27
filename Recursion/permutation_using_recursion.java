class HelloWorld {
    public static void main(String[] args) {
        int count=0;
        perm("","abc");
        // System.out.println("Try programiz.pro");
        System.out.println(count);
    }
    public static void perm(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i=0;i<p.length()+1;i++){
             String first = p.substring(0,i);
             String last = p.substring(i,p.length());
             perm(first+ch+last,up.substring(1));
        }
    }
}
