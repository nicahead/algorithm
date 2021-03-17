package 剑指offer;

//剑指 Offer 12. 矩阵中的路径
public class JZ12 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 如果匹配到了字符串的第一位，则从[i,j]这个坐标开始查找
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, word)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word) {
        // 完成了字符串匹配，则返回true
        if (word.length() == 0) {
            return true;
        }
        // 此路不通，返回false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(0)) {
            return false;
        }
        // 若没有完成，则继续递归
        // 暂存
        char temp = board[i][j];
        // 防止本次寻找的过程中再次使用。保证在“当前”匹配方案中不要走回头路
        board[i][j] = ' ';
        boolean res = dfs(i - 1, j, board, word.substring(1)) || dfs(i + 1, j, board, word.substring(1)) || dfs(i, j - 1, board, word.substring(1)) || dfs(i, j + 1, board, word.substring(1));
        // 防止下次寻找的过程中再次使用，所以要恢复原样
        board[i][j] = temp;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String s = "AAB";
        JZ12 jz12 = new JZ12();
        boolean exist = jz12.exist(board, s);
    }
}
