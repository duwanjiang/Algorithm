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
// 👍 679 👎 0

package Week_03.Day03;

import java.util.LinkedList;

public class _200_NumberOfIslands {
    public static void main(String[] args) {
        _200_NumberOfIslands numberOfIslands = new _200_NumberOfIslands();
        Solution solution = numberOfIslands.new Solution();
        solution.numIslands(new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法二 BFS
     * 时间复杂度：O（mn）
     * 空间复杂度：O（min(M,N)）
     */
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid.length == 0) return 0;
            int count = 0, rn = grid.length, cn = grid[0].length;
            for (int i = 0; i < rn; i++) {
                for (int j = 0; j < cn; j++) {
                    if (grid[i][j] == '1') { //发现岛屿
                        count++;
                        grid[i][j] = '0';
                        LinkedList<Integer> neighbors = new LinkedList<>();
                        neighbors.addLast(cn * i + j);//用于存储坐标:行*总列数+列数
                        while (!neighbors.isEmpty()) {
                            int k = neighbors.pollFirst();
                            int r = k / cn, c = k % cn;// 解析出坐标
                            if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                                grid[r - 1][c] = '0';
                                neighbors.addLast(cn * (r - 1) + c);
                            }
                            if (r + 1 < rn && grid[r + 1][c] == '1') {
                                grid[r + 1][c] = '0';
                                neighbors.addLast(cn * (r + 1) + c);
                            }
                            if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                                grid[r][c - 1] = '0';
                                neighbors.addLast(cn * r + c - 1);
                            }
                            if (c + 1 < cn && grid[r][c + 1] == '1') {
                                grid[r][c + 1] = '0';
                                neighbors.addLast(cn * r + c + 1);
                            }
                        }
                    }
                }
            }
            return count;
        }
    }
//    /**
//     * 方法一 DFS
//     * 时间复杂度：O（mn）
//     * 空间复杂度：O（mn）
//     */
//    class Solution {
//        public int numIslands(char[][] grid) {
//            if (grid.length == 0) return 0;
//            int count = 0;
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[i].length; j++) {
//                    if (grid[i][j] == '1') { //发现岛屿
//                        count++;
//                        dfs(grid, i, j); //消灭岛屿
//                    }
//                }
//            }
//            return count;
//        }
//
//        //进行dfs消灭岛屿的状态为0
//        private void dfs(char[][] grid, int i, int j) {
//            // terminator 如果超出范围或值为0，表示岛屿边界
//            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
//            // 消灭岛屿
//            grid[i][j] = '0';
//            // drill down 从4个方向依次递归
//            dfs(grid, i - 1, j);
//            dfs(grid, i + 1, j);
//            dfs(grid, i, j - 1);
//            dfs(grid, i, j + 1);
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}