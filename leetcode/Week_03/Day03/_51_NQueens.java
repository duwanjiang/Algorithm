//LeetCode题目: 51_N皇后

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 478 👎 0

package Week_03.Day03;

import java.util.ArrayList;
import java.util.List;

public class _51_NQueens {
    public static void main(String[] args) {
        Solution solution = new _51_NQueens().new Solution();
        solution.solveNQueens(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 回溯
     * 时间复杂度：O（n!）
     * 空间复杂度：O（n）
     */
    class Solution {
        int n;
        int[] queens;
        int[] rows;
        int[] hills;
        int[] dales;
        List<List<String>> output = new ArrayList<>();


        public List<List<String>> solveNQueens(int n) {
            //初始化变量
            this.n = n;
            rows = new int[n];
            queens = new int[n];
            hills = new int[2 * n - 1]; //存储主对角线值 row + col
            dales = new int[4 * n - 1]; //存储次对角线值 row - col + 2n
            backtrack(0);
            return output;
        }

        // 回溯遍历棋盘
        private void backtrack(int row) {
            for (int col = 0; col < n; col++) {
                if (isNotUnderAttack(row, col)) {
                    placeQueen(row, col); //放置棋子
                    if (row + 1 >= n) addSolution(); //打印结果
                    else backtrack(row + 1); //下钻
                    removeQueen(row, col); //回溯
                }
            }
        }

        private void removeQueen(int row, int col) {
            queens[row] = 0;
            rows[col] = 0;
            dales[row - col + 2 * n] = 0; //次对角线
            hills[row + col] = 0; //主对角线
        }

        //保存结果
        private void addSolution() {
            ArrayList<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int col = queens[i];
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < col; j++) sb.append("."); // col列之前加"."
                sb.append("Q"); // col位置打印"Q"
                for (int j = 0; j < n - col - 1; j++) sb.append(".");  // col列之前加"."
                solution.add(sb.toString());
            }
            output.add(solution);
        }

        private void placeQueen(int row, int col) {
            queens[row] = col;
            rows[col] = 1;
            dales[row - col + 2 * n] = 1; //次对角线
            hills[row + col] = 1; //主对角线
        }

        //检查是否受到攻击
        private boolean isNotUnderAttack(int row, int col) {
            return rows[col] + hills[row + col] + dales[row - col + 2 * n] == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}