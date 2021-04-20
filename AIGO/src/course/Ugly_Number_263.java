package course;

public class Ugly_Number_263 {
    //判断一个数的公因数是不是只有2，3，5
    public static void main(String[] args) {
        System.out.println(solution_1(7));
    }

    //将这个数一直除以2，直到除不尽，然后除以3，5直到除不尽
    // 如果最后的结果是1，则是丑数
    public static boolean solution_1(int n) {
        if (n < 1) {
            return false;
        }
        int[] pf = new int[]{2, 3, 5};
        for (int i : pf) {
            while (n % i == 0) {
                n /= i;
            }
        }
        return n == 1;
    }
}
