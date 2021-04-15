package week5;

public class Longest_Palindromic_Substring_5 {
    public static void main(String[] args) {
        String s = "abbd";
        System.out.println(solution_2(s));
    }
    //solution_1为中心扩展算法，时间复杂度O(n^2),空间复杂度O(1)
    public static String solution_1(String s) {
        //处理边界情况
        if (s == null || s.length() < 1) {
            return "";
        }
        //使用两个变量存放每次循环之后最长的子串下标
        int start = 0, end = 0;
        //遍历一遍字符串
        for (int i = 0; i < s.length(); i++) {
            //求出以第i个元素为中心的回文子串长度
            int len1 = expandAroundCenter(s, i, i);
            //求出以第i个元素后面的空格为中心的回文子串的长度
            int len2 = expandAroundCenter(s, i, i + 1);
            //取这两个中心中更长的回文子串长度
            int len = Math.max(len1, len2);
            //如果此时的回文子串长度比之前的最长回文子串长度更长，则更新最长回文子串的下标
            if (len > end - start) {
                //start为此时的最长回文子串的左端点下标
                start = i - (len - 1) / 2;
                //end为此时的最长回文子串的右端点下标
                end = i + len / 2;
            }
        }
        //返回遍历整个字符串之后的最长回文子串的下标
        return s.substring(start, end + 1);
    }

    //求以某个点为中心的回文子串长度
    public static int expandAroundCenter(String s, int left, int right) {
        //L和R存放最长回文子串的下标，初始值为中点或中点两边的元素
        int L = left, R = right;
        //如果子串左右端点值相同，则端点外延
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        //返回回文子串的长度
        return R - L - 1;
    }

    //solution_2为动态规划算法，时间复杂度O(n^2),空间复杂度O(n^2)
    public static String solution_2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        //保存最大回文串长度，初始时设为1
        int maxLen = 1;
        //保存最大回文串下标
        int begin = 0;
        //dp[i][j]表示子串Si到Sj是不是回文串
        boolean[][] dp = new boolean[len][len];
        //所有长度为1的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        //L为枚举的子串的长度
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                //i和j为枚举子串的左右端点
                int j = L + i - 1;
                //如果j越界则跳出循环
                if (j >= len) {
                    break;
                }
                //左右端点不等则不是回文串
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    //子串长度为2时或3时，即子串去掉左右端点为回文串时，此时子串回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        //此时子串是否为回文串取决于去掉去掉左右端点之后是否仍为回文串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                //如果存在回文串且此时回文串的长度大于最大回文串长度，则更新最大回文串的长度和起始下标
                if (dp[i][j] && j - i + 1 > maxLen) {
                    //更新最大回文串长度
                    maxLen = j - i + 1;
                    //更新最大回文串起始下标
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
