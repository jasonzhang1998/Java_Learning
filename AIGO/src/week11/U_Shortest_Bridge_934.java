package week11;

import java.util.Stack;

public class U_Shortest_Bridge_934 {
    //nums数组的作用是方便寻找与某点相邻的点坐标
    int[][] nums = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m, n;
    //visited数组记录所有被访问过的点
    boolean[][] visited;

    public static void main(String[] args) {

        U_Shortest_Bridge_934 foo = new U_Shortest_Bridge_934();
        System.out.println(foo.solution_1(new int[][]{}));
    }


    public int solution_1(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        //栈 s 用于存放第一个岛屿的所有边界点的坐标
        Stack<int[]> s = new Stack<>();

        //找到第一个岛屿的所有点并将其坐标存放到栈 s 中
        for (int i = 0; i < m; i++) {
            //bl变量表示是否找到了第一个岛玙的所有边界点
            boolean bl = false;
            for (int j = 0; j < n; j++) {
                //双重循环找到第一个岛的某一个点
                if (grid[i][j] == 1) {
                    //从找到的第一个点开始，使用dfs找到第一个岛屿的所有边界点
                    dfs(s, grid, i, j);
                    //找到全部边界点之后，设置变量值为true，然后跳出当前循环
                    bl = true;
                    break;
                }
            }
            //如果已经找到第一个岛，则跳出当前循环
            if (bl) break;
        }

        //ans记录向外扩散的层数，即最短的桥的长度
        int ans = 0;
        Stack<int[]> s1 = new Stack<>();
        //
        while (!s.isEmpty()) {
            //遍历第一座岛的所有边界点
            while (!s.isEmpty()) {
                //得到某个边界点的坐标
                int[] tmp = s.pop();
                int x = tmp[0];
                int y = tmp[1];
                //遍历该点的四个相邻节点，即向外扩散一次
                for (int i = 0; i < 4; i++) {
                    int a = x + nums[i][0];
                    int b = y + nums[i][1];
                    //只判断给定区域内的且不是第一座岛屿内的点
                    if (inArea(a, b) && !visited[a][b]) {
                        //如果相邻节点的值为1，说明找到了第二座岛，返回此时已扩散的层数
                        if (grid[a][b] == 1) return ans;
                        else {
                            //若相邻节点值为0，则将该相邻节点加入到已被访问的节点
                            visited[a][b] = true;
                            //栈s1存放第一座到扩散后的新边界点的坐标
                            s1.push(new int[]{a, b});
                        }
                    }
                }
            }
            //扩散一层后，ans数量加一
            ans++;
            //下一轮遍历扩散后的第一座岛的边界点
            s = s1;
            s1 = new Stack<>();
        }
        //若没有找到第二座岛屿，则返回此时的扩散层数
        return ans;
    }

    //通过深度优先遍历寻找第一个岛的所有边界点，并存放到栈s中，visited数组记录访问过的点
    public void dfs(Stack<int[]> s, int[][] grid, int x, int y) {
        //bl变量用于判断该点是否存在值为零的点，即判断该点是不是岛屿的边界点
        boolean bl = false;
        //将该点设置为已被访问过，visited数组记录第一座岛的所有点
        visited[x][y] = true;
        //遍历该点相邻的四个节点
        for (int i = 0; i < 4; i++) {
            int a = x + nums[i][0];
            int b = y + nums[i][0];
            //判断是否在给定区域内
            if (inArea(a, b)) {
                //若相邻节点为0，则说明该点为边界点，设置bl为true
                if (grid[a][b] == 0) {
                    bl = true;
                } else {
                    //相邻节点不为0，则说明进行深度优先遍历，直到找到边界点
                    if (!visited[a][b]) dfs(s, grid, a, b);
                }
            }
        }
        //如果该点是边界点，则将该点的坐标保存到栈s中
        if (bl) s.push(new int[]{x, y});
    }

    //判断输入的点是否在给定的区域里面
    public boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
