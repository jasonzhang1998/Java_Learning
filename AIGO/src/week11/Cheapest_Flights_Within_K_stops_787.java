package week11;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Cheapest_Flights_Within_K_stops_787 {
    public static void main(String[] args) {
        int[][] flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        Cheapest_Flights_Within_K_stops_787 foo = new Cheapest_Flights_Within_K_stops_787();
        System.out.println(foo.solution_1(3, flights, 0, 1, 1));
        System.out.println(solution_2(3, flights, 0, 1, 1));
        System.out.println(solution_3(3, flights, 0, 2, 1));
    }

    private int[][] graph;
    private boolean[] visited;
    private int res = Integer.MAX_VALUE;

    //使用深度优先遍历来进行暴力搜索，找到所有的路径然后选最少的价格
    //会超时
    public int solution_1(int n, int[][] flights, int src, int dst, int k) {
        //求实际的中转限制次数
        k = Math.min(k, n - 2);

        //使用邻接矩阵存放图结构
        this.graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        this.visited = new boolean[n];
        dfs(src, dst, k + 1, 0);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    private void dfs(int src, int dst, int k, int cost) {
        //源点和终点相同，cost为0；找到了一条从源点到终点的路径，
        // 记录此时已经花费的价格，并更新到res
        if (src == dst) {
            res = cost;
            return;
        }
        //如果源点和终点不同，而且中转限制次数为0，则说明无法到达，
        // 直接返回不作操作
        if (k == 0) {
            return;
        }

        //遍历源点到其他点的所有路径
        for (int i = 0; i < graph[src].length; i++) {
            //如果源点和i点存在路径，则把i点作为下一站
            if (graph[src][i] > 0) {
                //如果此节点已经被访问过，说明之前的路径已经经过i点，
                // 则不能作为下一站否则会出现环
                if (visited[i]) {
                    continue;
                }
                //res代表目前从源点到终点的最少价格，如果现在还没到终点
                // 已花费的价格就比res大了，那么就没必要继续了
                if (cost + graph[src][i] > res) {
                    continue;
                }
                //将此节点置为被访问过的节点，将该点添加到路径中
                visited[i] = true;
                //然后从此节点出发，继续往后找，中转次数减一
                dfs(i, dst, k - 1, cost + graph[src][i]);
                //从i出发找到或者未找到dst回溯回来的时候，
                // 需要从i+1重新出发，此时需要将i节点设为未被访问过
                visited[i] = false;
            }
        }
    }


    //dijkstra算法求最短路径
    //会超时
    public static int solution_2(int n, int[][] flights, int src, int dst, int K) {
        // 使用邻接矩阵表示有向图，0 表示不连通
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // 向集合添加一个记录（起点, 费用, 站数限制）的数组，K + 1 表示可以走过站点的个数
        minHeap.offer(new int[]{src, 0, K + 1});

        while (!minHeap.isEmpty()) {
            int[] front = minHeap.poll();
            int v = front[0];
            int price = front[1];
            int k = front[2];

            if (v == dst) {
                return price;
            }

            // 如果还可以中转一个站
            if (k > 0) {
                for (int i = 0; i < n; i++) {
                    // 并且存在一条有向边
                    if (graph[v][i] > 0) {
                        // 优先队列中存入：有向边指向的顶点 i、从起点 src 到 i 的总路径长度、还有多少站可以中转
                        minHeap.offer(new int[]{i, price + graph[v][i], k - 1});
                    }
                }
            }
        }
        return -1;
    }

    //贝尔曼-福特算法，最多中转k次，即最多进行k+1次松弛操作
    //以边为单位去遍历，使用的是动态规划的思想
    public static int solution_3(int n, int[][] flights, int src, int dst, int k) {
        //dp[i][j]表示经过j次松弛操作之后，源点到i点的最短距离
        int[][] dp = new int[n][k + 1];
        //首先将dp数组初始化为一个非常大的值
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        //将源点到源点的距离设置为0
        for (int i = 0; i < k + 1; i++) {
            dp[src][i] = 0;
        }
        //进行第一次松弛操作，只需要对与src相邻的边进行操作（即中转0次，直达的情况）
        for (int[] flight : flights) {
            if (flight[0] == src) {
                dp[flight[1]][0] = flight[2];
            }
        }
        //第一层循环表示经过第2次到第k+1次松弛操作（计算到中转k次的情况）
        for (int i = 1; i < k + 1; i++) {
            //第二层循环表示每次松弛操作都对所有边进行操作
            for (int[] flight : flights) {
                //为什么要有这个if判断，因为只有star节点不是无穷大的边，才会生效，否则还是无穷
                if(dp[flight[0]][i - 1] != Integer.MAX_VALUE){
                    //为什么是和dp[flight[1]][i]而不是dp[flight[1]][i]比较，因为要找到当前所有边松驰过后的最短路径
                    dp[flight[1]][i] = Math.min(dp[flight[1]][i], dp[flight[0]][i - 1] + flight[2]);

                }
            }
        }
        return dp[dst][k] != Integer.MAX_VALUE ? dp[dst][k] : -1;
    }
}
