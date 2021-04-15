package demo4;

import java.util.ArrayList;
import java.util.Random;

public class DemoArrayList_1 {
    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            array.add(r.nextInt(33) + 1);
        }
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
}
