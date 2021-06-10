package week10;

import java.util.*;

public class Longest_Word_in_Dictionary_720 {
    public static void main(String[] args) {
        String[] words = {"d", "di", "din", "dinn", "dinne", "dinner"};
        System.out.println(solution_1(words));
    }

    //暴力搜索
    public static String solution_1(String[] words) {
        //记录最后的答案，初始时为空
        String ans = "";
        Set<String> wordset = new HashSet<>();
        //把所有元素都放到hashset里面
        for (String word : words) wordset.add(word);
        for (String word : words) {
            //如果此时单词的长度更长或者长度相等的情况下字典序更小，则进行下一步判断
            if (word.length() > ans.length() ||
                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean good = true;
                //如果这个单词的所有前缀都在hashset中，则更新答案
                for (int i = 1; i < word.length(); i++) {
                    if(!wordset.contains(word.substring(0,i))){
                        good = false;
                        break;
                    }
                }
                if(good) ans = word;
            }
        }
        return ans;
    }

}
