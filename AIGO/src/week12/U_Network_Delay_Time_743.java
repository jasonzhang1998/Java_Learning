package week12;

import java.util.*;

public class U_Network_Delay_Time_743 {
    public static void main(String[] args) {

    }

    public static int solution_1(int[][] times, int n, int k) {
        //使用map存放所有的节点以及从其出发的所有边
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        //使用小顶堆对各个顶点的距离进行比较，以选取添加到dist中的点
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, k});
        //使用一个哈希表存放已经确定的个点的最短路径集合
        Map<Integer, Integer> dist = new HashMap<>();
        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            //每次只将节点第一次出现时（小顶堆中排序最小）的距离值存入dist
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            //将从node出发的边放入小顶堆去进行比较
            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d + d2, nei});
                }
            }
        }
        //dist里面的元素数量若不是n说明有节点不可达
        if(dist.size() != n) return -1;
        int ans = 0;
        //到达最远的节点所需的距离即为传到整个网络所需的时间
        for(int cand : dist.values())
            ans = Math.max(cand, ans);
        return ans;
    }
}
