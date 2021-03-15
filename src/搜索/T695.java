package 搜索;

//695. 岛屿的最大面积
public class T695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        // 找出所有可能组成岛屿的起点，取最大值
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 一旦找到一个等于1的格子，则开始深度优先搜索
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }

    // 寻找岛屿：从某一位置出发，向四个方向寻找相连的土地
    private int dfs(int x, int y, int[][] grid) {
        // 递归终止条件
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) return 0;
        // 将该格子置为0，以保证每块陆地只访问一次
        grid[x][y] = 0;
        int count = 1;
        // 向四个方向递归地DFS
        count += dfs(x + 1, y, grid);
        count += dfs(x - 1, y, grid);
        count += dfs(x, y + 1, grid);
        count += dfs(x, y - 1, grid);
        return count;
    }
}
