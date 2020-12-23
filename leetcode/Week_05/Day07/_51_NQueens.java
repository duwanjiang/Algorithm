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
// 👍 505 👎 0

package Week_05.Day07;

import java.util.ArrayList;
import java.util.List;

public class _51_NQueens {
    public static void main(String[] args) {
        Solution solution = new _51_NQueens().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 回溯
     * 时间复杂度：O（n!）
     * 空间复杂度：O（n）
     */
    class Solution {
        int n;
        int[] rows;
        int[] queens;
        int[] pie; //撇
        int[] na; //捺
        List<List<String>> list = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            rows = new int[n];
            queens = new int[n];
            pie = new int[2 * n - 1]; //row + col 是固定值
            na = new int[4 * n - 1]; // row - col + 2n 是固定值
            backTrack(0);
            return list;
        }

        //回溯
        private void backTrack(int row) {
            for (int col = 0; col < n; col++) {
                //判断是否受到攻击
                if (isNotUnderAttack(row, col)) {
                    placeQueen(row, col); //放置王后
                    if (row >= n - 1) printResult();//打印结果
                    else backTrack(row + 1); // 下钻
                    removeQueen(row, col); // 回溯
                }
            }
        }

        private void removeQueen(int row, int col) {
            queens[row] = 0;
            rows[col] = 0;
            pie[row + col] = 0;
            na[row - col + 2 * n] = 0;
        }

        private void printResult() {
            ArrayList<String> strings = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                StringBuilder sb = new StringBuilder();
                int col = queens[row];
                for (int i = 0; i < col; i++) sb.append(".");
                sb.append("Q");
                for (int i = 0; i < n - col - 1; i++) sb.append(".");
                strings.add(sb.toString());
            }
            list.add(strings);
        }

        private void placeQueen(int row, int col) {
            queens[row] = col;
            rows[col] = 1;
            pie[row + col] = 1;
            na[row - col + 2 * n] = 1;
        }

        private boolean isNotUnderAttack(int row, int col) {
            return rows[col] + pie[row + col] + na[row - col + 2 * n] == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}