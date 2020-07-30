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
// 👍 480 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.List;

public class _51_NQueens {
    public static void main(String[] args) {
        Solution solution = new _51_NQueens().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 回溯
     * 先在第一层放第一颗棋子，然后再将这颗棋子横向、主对角线、次对角线标记为占用
     * 然后在第一层放第二颗棋子，如果能放则依次放后续棋子，如果不能放则回溯，重新放上一颗棋子
     * 时间复杂度：O（n!）
     * 空间复杂度：O（n）
     */
    class Solution {
        int n; //记录棋盘大小
        int[] rows; //记录当前行的列
        int[] hills; //记录主对角线位置
        int[] dales; //记录次对角线位置
        int[] queens; //记录皇后

        ArrayList<List<String>> lists = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            if (n == 0) return lists;
            //初始化变量
            this.n = n;
            rows = new int[n];
            queens = new int[n];
            hills = new int[2 * n - 1]; // row + col
            dales = new int[4 * n - 1]; // row - col + 2n
            backTrack(0);
            return lists;
        }

        private void backTrack(int row) {
            for (int col = 0; col < n; col++) {
                if (isNotUnderAttack(row, col)) { //判断是否会被攻击
                    saveQueen(row, col); //保存皇后
                    if (row + 1 >= n) addSulosion(); //当最后一行时打印结果
                    else backTrack(row + 1); //走下一行棋
                    removeQueen(row, col); //删除皇后 会输
                }
            }
        }

        private void addSulosion() {
            ArrayList<String> subStr = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                StringBuilder sb = new StringBuilder();
                int col = queens[row];
                for (int i = 0; i < col; i++) { //在皇后所在列之前添加"."
                    sb.append(".");
                }
                sb.append("Q");
                for (int i = 0; i < n - col - 1; i++) { //在皇后所在列之前添加"."
                    sb.append(".");
                }
                subStr.add(sb.toString());
            }
            lists.add(subStr);
        }

        private void removeQueen(int row, int col) {
            queens[row] = 0;
            rows[col] = 0;
            hills[row + col] = 0;
            dales[row - col + 2 * n] = 0;
        }

        private void saveQueen(int row, int col) {
            queens[row] = col;
            rows[col] = 1;
            hills[row + col] = 1;
            dales[row - col + 2 * n] = 1;
        }

        private boolean isNotUnderAttack(int row, int col) {
            return rows[col] + hills[row + col] + dales[row - col + 2 * n] == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}