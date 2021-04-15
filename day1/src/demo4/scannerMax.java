package demo4;

import java.util.Scanner;

public class scannerMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (b > a) {
            a = b;
        }
        int c = sc.nextInt();
        if (c > a) {
            a = c;
        }
        System.out.println("输入的最大值是" + a);

    }
}
