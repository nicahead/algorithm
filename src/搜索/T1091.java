package 搜索;

import java.util.LinkedList;
import java.util.Queue;

//1091. 二进制矩阵中的最短路径
public class T1091 {

    // 在每个位置可以走的八个方向，方便复用
    private int[][] directions = new int[][]{{-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 定义队列，每一个可能到达的节点
        Queue<int[]> queue = new LinkedList<>();
        // 判断边界条件，是否能直接返回
        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) return -1;
        // 将起始位置加入到队列中，同时更新备忘录
        queue.offer(new int[]{0, 0});
        // 不另外开辟数组。使用grid记录到达{i,j}节点需要的步长。初始情况下为1
        grid[0][0] = 1;
        // 当前还有未访问到的节点，且右下角还未访问到
        while (!queue.isEmpty() && grid[m - 1][n - 1] == 0) {
            // 取出一个位置节点，开始广度优先寻找下一个可能到达的节点
            int[] xy = queue.poll();
            // 暂存到达该节点所需步长
            int lenTemp = grid[xy[0]][xy[1]];
            // 尝试所有可能的走法（八个方向）
            for (int i = 0; i < directions.length; i++) {
                // 横轴新坐标
                int newX = xy[0] + directions[i][0];
                // 纵轴新坐标
                int newY = xy[1] + directions[i][1];
                // 条件判断，过滤掉不符合条件的位置。新坐标合法，且是畅通路径
                if (isLegal(newX, newY, m, n) && grid[newX][newY] == 0) {
                    // 新节点入栈
                    queue.offer(new int[]{newX, newY});
                    // 新节点更新，到达该节点的路径长度加1
                    grid[newX][newY] = lenTemp + 1;
                }
            }
        }
        // 遍历结束，如果成功到达右下角，则grid[m - 1][n - 1]已被更新，值不为0
        return grid[m - 1][n - 1] == 0 ? -1 : grid[m - 1][n - 1];
    }

    // 判断坐标是否合法
    private boolean isLegal(int x, int y, int m, int n) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
