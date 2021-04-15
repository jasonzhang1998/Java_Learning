package demo4;

import java.util.Scanner;

public class StringChracteristic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int b = 0;
        int s = 0;
        int n = 0;
        int e = 0;
        byte[] bytes = str.getBytes();
        for (int i = 0; i < str.length(); i++) {
            if (bytes[i] > 47 && bytes[i] < 58) {
                n++;
            } else if (bytes[i] > 64 && bytes[i] < 91) {
                b++;
            } else if (bytes[i] > 96 && bytes[i] < 123) {
                s++;
            } else {
                e++;
            }

        }
        System.out.println("大写字母出现的次数"+b);
        System.out.println("小写字母出现的次数"+s);
        System.out.println("数字出现的次数"+n);
        System.out.println("其它字符出现的次数"+e);
    }
}
