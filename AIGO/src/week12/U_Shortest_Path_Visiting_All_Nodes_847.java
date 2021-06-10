package week12;

import java.util.LinkedList;
import java.util.Queue;

public class U_Shortest_Path_Visiting_All_Nodes_847 {
    public static void main(String[] args) {

    }

    public static int solution_1(int[][] graph) {
        int len = graph.length;
        if (graph == null || graph.length == 0)
            return 0;
        boolean[][] visited = new boolean[len][1 << len];
        int finishState = (1 << len) - 1;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            queue.offer(new int[]{i, 1 << i});
        }
        int step = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] node = queue.poll();
                if (finishState == node[1])
                    return step;
                for (int next : graph[node[0]]) {
                    int nextState = node[1] | (1 << next);
                    if (visited[next][nextState])
                        continue;
                    visited[next][nextState] = true;
                    queue.offer(new int[]{next, nextState});
                }
            }
            step++;
        }
        return step;
    }
}
