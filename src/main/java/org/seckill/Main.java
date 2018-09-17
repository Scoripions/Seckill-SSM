package org.seckill;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        char[] str1 = s1.toCharArray();
        String s2 = in.nextLine();
        char[] str2 = s2.toCharArray();
        int count = 0;
        int sum = str1.length;
        for (int i = 0; i < str1.length; i++) {
            if ((str1[i] >= 'a' && str1[i] <= 'z') || (str1[i] >= 'A' && str1[i] <= 'Z') || (str1[i] >= '1' && str1[i] <= '9')) {
                if (str2[i] == '1') {
                    count++;
                }
            } else {
                if (str2[i] == '0') {
                    count++;
                }
            }
        }
        System.out.println(String.format("%.2f%%", (double)(count*100)/ sum));

       /* Scanner s = new Scanner(System.in);
        String str1 = s.nextLine();
        char[] c1 = str1.toCharArray();
        String str2 = s.nextLine();
        char[] c2 = str2.toCharArray();
        int right = 0;
        int sum = str1.length();
        for(int i = 0; i < str1.length();i++){
            if(c1[i]>='0'&&c1[i]<='9'||
                    c1[i]>='a'&&c1[i]<='z'||
                    c1[i]>='A'&&c1[i]<='Z'){
                if(c2[i]=='1'){
                    right++;
                }
            }else{
                if(c2[i]=='0'){
                    right++;
                }
            }
        }
        System.out.println(String.format("%.2f%%", (double)(right*100)/sum));*/
    }
}
