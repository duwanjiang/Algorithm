//LeetCode题目: 200_岛屿数量

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 681 👎 0

package editor.cn;

public class _200_NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new _200_NumberOfIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 DFS
     * 通过遍历每个坐标，只要发现是1就使用DFS将与之相邻的1全部置为0
     * 时间复杂度：O（mn）
     * 空间复杂度：O（mn）
     */
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid.length == 0) return 0;
            int count = 0, nr = grid.length, nc = grid[0].length;
            for (int i = 0; i < nr; i++) {
                for (int j = 0; j < nc; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int row, int col) {
            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') return;
            grid[row][col] = '0'; //消除岛屿
            dfs(grid, row - 1, col);
            dfs(grid, row + 1, col);
            dfs(grid, row, col - 1);
            dfs(grid, row, col + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}