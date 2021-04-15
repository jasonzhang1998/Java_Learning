package demo2;

public class JavaMethod {
    public static void main(String[] args) {
//        same(4, 5);
//        System.out.println(sum());
        print(5);
    }

    public static void same(int a, int b) {
        if (a == b) {
            System.out.println("same");
        } else {
            System.out.println("different");
        }
    }
    public static int sum(){
        int sum = 0;
        for(int i = 1 ; i < 101 ; i++){
            sum = sum + i;
        }
//        System.out.println(sum);
        return sum;
    }
    public static void print(int a){
        for(int i = 1;i < (a+1);i++){
            System.out.println("HelloWorld!" + i);
        }
    }
}
