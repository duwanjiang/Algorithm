//LeetCode题目: 529_扫雷游戏

//让我们一起来玩扫雷游戏！ 
//
// 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）
//地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。 
//
// 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板： 
//
// 
// 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。 
// 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。 
// 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。 
// 如果在此次点击中，若无更多方块可被揭露，则返回面板。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 
//
//[['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'M', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E'],
// ['E', 'E', 'E', 'E', 'E']]
//
//Click : [3,0]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 示例 2： 
//
// 输入: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'M', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//Click : [1,2]
//
//输出: 
//
//[['B', '1', 'E', '1', 'B'],
// ['B', '1', 'X', '1', 'B'],
// ['B', '1', '1', '1', 'B'],
// ['B', 'B', 'B', 'B', 'B']]
//
//解释:
//
// 
//
// 
//
// 注意： 
//
// 
// 输入矩阵的宽和高的范围为 [1,50]。 
// 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。 
// 输入面板不会是游戏结束的状态（即有地雷已被挖出）。 
// 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 86 👎 0

package editor.cn;

import java.util.LinkedList;

public class _529_Minesweeper {
    public static void main(String[] args) {
        Solution solution = new _529_Minesweeper().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法二 bfs
     * 时间复杂度：O（n^2）
     * 空间复杂度：O（n^2）
     */
    class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {
            int nr = board.length, nc = board[0].length;
            LinkedList<int[]> deque = new LinkedList<>();
            deque.add(click);
            while (!deque.isEmpty()) {
                int[] poll = deque.poll();
                int row = poll[0], col = poll[1];
                //判断当前是否为地雷
                if (board[row][col] == 'M') board[row][col] = 'X';
                else {
                    //先找出第一个地雷
                    int count = 0;
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) continue; //排除当前位置
                            int r = row + i, c = col + j;
                            if (r < 0 || c < 0 || r >= nr || c >= nc) continue;
                            if (board[r][c] == 'M') count++;
                        }
                    }
                    if (count > 0) { //标记该坐标标记为地雷数
                        board[row][col] = (char) (count + '0');
                    } else { //采用bfs遍历坐标四周
                        board[row][col] = 'B'; //表示当前坐标四周没有地雷
                        for (int i = -1; i < 2; i++) {
                            for (int j = -1; j < 2; j++) {
                                if (i == 0 && j == 0) continue; //排除当前位置
                                int r = row + i, c = col + j;
                                if (r < 0 || c < 0 || r >= nr || c >= nc) continue;
                                if (board[r][c] == 'E'){
                                    deque.add(new int[]{r, c}); //加入队列，遍历四周坐标
                                    board[r][c] = 'B'; //预先添加标记，有可能被重新标记
                                }
                            }
                        }
                    }
                }
            }
            return board;
        }
    }
//    /**
//     * 方法一 dfs
//     * 时间复杂度：O（n^2）
//     * 空间复杂度：O（n^2）
//     */
//    class Solution {
//        public char[][] updateBoard(char[][] board, int[] click) {
//            int nr = board.length, nc = board[0].length;
//            int row = click[0], col = click[1];
//            //判断当前是否为地雷
//            if (board[row][col] == 'M') board[row][col] = 'X';
//            else {
//                //先找出第一个地雷
//                int count = 0;
//                for (int i = -1; i < 2; i++) {
//                    for (int j = -1; j < 2; j++) {
//                        if (i == 0 && j == 0) continue; //排除当前位置
//                        int r = row + i, c = col + j;
//                        if (r < 0 || c < 0 || r >= nr || c >= nc) continue;
//                        if (board[r][c] == 'M') count++;
//                    }
//                }
//                if (count > 0) { //标记该坐标标记为地雷数
//                    board[row][col] = (char) (count + '0');
//                } else { //采用dfs遍历坐标四周
//                    board[row][col] = 'B'; //表示当前坐标四周没有地雷
//                    for (int i = -1; i < 2; i++) {
//                        for (int j = -1; j < 2; j++) {
//                            if (i == 0 && j == 0) continue; //排除当前位置
//                            int r = row + i, c = col + j;
//                            if (r < 0 || c < 0 || r >= nr || c >= nc) continue;
//                            if (board[r][c] == 'E') updateBoard(board, new int[]{r, c}); //递归四周坐标
//                        }
//                    }
//                }
//            }
//            return board;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}