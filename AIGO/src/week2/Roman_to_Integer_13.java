package week2;

import java.util.HashMap;

public class Roman_to_Integer_13 {
    //罗马数字转为整数
    public static void main(String[] args) {
        System.out.println(solution_2("IM"));
    }

    //用哈希表存储每个字符代表的整数，然后用双指针判断前后两个字符代表的书的大小
    // 从而判断是相加还是相减
    public static int solution_1(String s) {
        HashMap<Character, Integer> hashtable = new HashMap<Character, Integer>();
        hashtable.put('I', 1);
        hashtable.put('V', 5);
        hashtable.put('X', 10);
        hashtable.put('L', 50);
        hashtable.put('C', 100);
        hashtable.put('D', 500);
        hashtable.put('M', 1000);
        int sum = 0;
        int preNum = hashtable.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = hashtable.get(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    //用switch语句代替哈希表实现
    public static int solution_2(String s) {
        int sum = 0;
        int preNum = swi(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = swi(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public static int swi(Character x) {
        switch (x) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
