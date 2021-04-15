package demo4;

import java.util.Arrays;

public class StringPractice {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(stringconcat(array));

    }

    public static String stringconcat(int[] array) {
        String str = "[";
        for (int i = 0; i < array.length; i++) {

            if (i == (array.length - 1)) {
                str += "word" + array[i] + "]";
                return str;
            }
            str += "word" + array[i] + "#";

        }
        return str;

    }
}
