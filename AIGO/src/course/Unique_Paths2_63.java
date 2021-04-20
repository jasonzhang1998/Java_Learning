package course;

public class Unique_Paths2_63 {
    //走方格问题中加了障碍点，还是使用动态规划解题
    //重点考虑边界条件的处理
    public static void main(String[] args) {
        System.out.println("大家晚上好呀");
        int[][] num = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(solution_1(num));
    }

    //思路：动态规划
    //任意方格的走法为其上和其左的走法之和
    //障碍点由于无法走到，因此需要将走法置为零
    //重点陷阱：对于第一列和第一行，当出现一个障碍之后
    //其之后的方格都不可能走到，因此需要将其之后的方格走法都置为零
    //特殊情况：当起点或终点存在障碍时，走法为零
    //Time O(mn)   Space O(1)   直接修改原数组，不需要额外开辟动态规划
    // 数组空间(如果是实际面试算法题，需要和面试官沟通是否可以对输入数据
    // 进行修改，如果不可以则需要额外的m*n的数组，之后可以继续用滚动数组思想优化)
    public static int solution_1(int[][] og) {
        //处理输入为零的情况
        if (og == null || og.length == 0) {
            return 0;
        }
        int m = og.length;
        int n = og[0].length;
        //如果起点或终点存在障碍，走法为零
        if(og[0][0]==1||og[m-1][n-1]==1){
            return 0;
        }
        int a = 0;
        int b = 1;
        //初始化动态规划数组的第一列
        //如果不存在障碍则初始化为1
        //若存在障碍，则跳出循环
        while(a<m){
            if(og[a][0]==1){
                og[a][0] = 0;
                break;
            }
            og[a][0] = 1;
            a++;
        }
        a++;
        //将第一个出现的障碍点之后的方格走法全部置为零
        while(a<m){
            og[a][0] = 0;
            a++;
        }
        //对于第一列的方格采取与第一行同样的初始化方式
        //需要注意的是，第一列方格初始化从第二个方格开始
        //因为第一个元素在行初始化时已经初始化过了
        while(b<n){
            if(og[0][b]==1){
                og[0][b] = 0;
                break;
            }
            og[0][b] = 1;
            b++;
        }
        b++;
        while(b<n){
            og[0][b] = 0;
            b++;
        }
        //动态规划代码部分
        //每个方格的走法为其上和其左方格的走法之和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (og[i][j] == 1) {
                    og[i][j] = 0;
                } else {
                    og[i][j] = og[i - 1][j] + og[i][j - 1];
                }
            }
        }
        //返回终点的走法数
        return og[m-1][n-1];
    }
}
