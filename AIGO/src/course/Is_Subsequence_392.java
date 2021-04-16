package course;

public class Is_Subsequence_392 {
    //判断字符串s是否为字符串t的子串
    //子串定义：删除字符串的一部分字符（或不删除）所得的字符串
    public static void main(String[] args) {
        String t = "sdgsidgsdua";
        String s = "sda";
        System.out.println(solution_1(s, t));
    }

    //双指针法，用两个指针分别指向s和t，比较指针指向的字符是否相同
    //相同则同时后移，否则指向t的字符串后移，当指向t的指针为空时，判断
    //指向s的指针是否为空，为空则返回true，否则返回false
    public static boolean solution_1(String s, String t) {
        //子串更长直接返回false
        if (s.length() > t.length()) {
            return false;
        }
        //注意边界情况
        if (s == null || s.length() == 0) {
            return true;
        }
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
            if (j == s.length()) {
                return true;
            }
        }
        return false;
    }
}
