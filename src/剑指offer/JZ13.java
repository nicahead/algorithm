package 剑指offer;

//剑指 Offer 13. 机器人的运动范围
public class JZ13 {
    public int movingCount(int m, int n, int k) {
        // 记录格子有没有被访问过，初始全为0
        int[][] visited = new int[m][n];
        return dfs(0, 0, k, visited);
    }

    private int dfs(int i, int j, int k, int[][] visited) {
        if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length || !islegal(i, j, k) || visited[i][j] == 1) {
            return 0;
        }
        // 留下访问标记
        visited[i][j] = 1;
        return 1 + dfs(i - 1, j, k, visited) + dfs(i + 1, j, k, visited) + dfs(i, j - 1, k, visited) + dfs(i, j + 1, k, visited);
    }

    // 判断是否满足 行坐标和列坐标的数位之和小于等于k
    private boolean islegal(int i, int j, int k) {
        int sum = 0;
        while (i != 0 || j != 0) {
            sum += i % 10;
            sum += j % 10;
            i = i / 10;
            j = j / 10;
        }
        return sum <= k;
    }

    public static void main(String[] args) {
        JZ13 jz13 = new JZ13();
        jz13.islegal(35,38,18);
    }
}
