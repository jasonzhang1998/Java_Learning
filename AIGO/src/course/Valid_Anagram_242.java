package course;

import java.util.HashMap;

public class Valid_Anagram_242 {
    public static void main(String[] args) {
        String s = "ca";
        String t = "acd";
        System.out.println(solution_1(s, t));
    }

    public static boolean solution_1(String s, String t) {
        //判断两个字符串的长度是否相同，不同则直接返回false
        if(s.length()!=t.length()){
            return false;
        }
        //使用一个数组来存放26个英文字母出现的次数
        int[] count = new int[26];
        //使用一个位置变量来对每个字母出现的次数进行计数
        int pos = 0;
        //遍历字符串s，每个字母出现一次，该字母对应的数组元素便加一
        for (int i = 0; i < s.length(); i++) {
            pos = s.charAt(i)-'a';
            count[pos]++;
        }
        //遍历字符串t，每个字母出现一次，该数组对应的数组元素则减一
        for (int i = 0; i < t.length(); i++) {
            pos = t.charAt(i)-'a';
            count[pos]--;
            /*
            遍历一遍s之后，所有字母出现的次数已经被统计完，若两个字符串
            相同，则数组元素全为0.否则t统计完后，数组中肯定会同时出现正
            数和负数。因此通过判断数组中是否存在负数值就可以判断两个字符
            串是否相同。
            */
            if(count[pos]<0){
                return false;
            }
        }
        return true;
    }
    //使用unicode的字符，即不只是26个英文字母的情况时
    public static boolean solution_2(String s,String t) {
        //判断两个字符串的长度是否相同，不同则直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        //当面对不确定数量的字符时，使用哈希表来存储字符及其出现的次数
        HashMap<Character, Integer> table = new HashMap<Character, Integer>();
        //遍历s，将出现的所有字符及其出现次数存储在哈希表中
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            /*/getOrDefault函数的作用，查找ch是否在哈希表中，如果在则返回
            ch对应的value值，否则返回设置的默认值
            put函数的作用为将一对key-value值存入哈希表中，如果之前不存在则
            执行插入操作，返回null。如果之前已经存在，则执行value替换操作，
            返回旧的value值。
            */
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        //遍历t，将出现的字母存储到字母表中，只是出现次数要减一
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            //若是出现出现次数为负数，则返回false
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}
