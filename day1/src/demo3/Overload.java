package demo3;
/*
方法的重载：
多个方法的名称一样，但是参数列表不一样

方法重载与下列因素相关：
1、参数个数不一样
2、参数类型不同
3、参数的多类型顺序不同

方法重载与下列因素无关：
1、参数的名称
2、方法的的返回值类型

在调用println语句时，其实就是进行了多种数据类型输出的重载



*/
public class Overload {
    public static void main(String[] args) {
        System.out.println(same(4,6));

    }
    public static boolean same(byte a , byte b){
        return a == b;
    }
    public static boolean same(short a , short b){
        return a == b;
    }
    public static boolean same(int a , int b){
        return a == b;
    }
    public static boolean same(long a , long b){
        return a == b;
    }
}
