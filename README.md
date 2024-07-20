# DSA

import java.util.*;
public class Main{
public static void main(String[] args){
Scanner sc= new Scanner(System.in);
int i = sc.nextInt();
int k=0;
String str = Integer.toString(i);
char[] chr = str.toCharArray();
StringBuilder strb = new StringBuilder();
char temp = chr[0];
chr[0]= chr[chr.length-1];
chr[chr.length-1]=temp;
for(int j=0;j<chr.length;j++){
    strb.append(chr[j]);
}
System.out.println(Integer.parseInt(strb.toString()));
}
}
