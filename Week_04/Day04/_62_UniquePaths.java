//LeetCode题目: 62_不同路径

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 
// 👍 630 👎 0

package editor.cn;

public class _62_UniquePaths {
    public static void main(String[] args) {
        Solution solution = new _62_UniquePaths().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法三 二项式
     * 时间复杂度：O（m）
     * 空间复杂度：O（1）
     */
    class Solution {
        public int uniquePaths(int m, int n) {
            if (n == 0 || m == 0) return 0;
            int N = (m - 1) + (n - 1); //总的移动步数
            int k = m - 1; //记录向下移动步数
            double res = 1;
            // here we calculate the total possible path number
            // Combination(N, k) = n! / (k!(n - k)!)
            // reduce the numerator and denominator and get
            // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
            for (int i = 1; i <= k; i++) {
                res = res * (N - k + i) / i;
            }
            return (int) res;
        }
    }
//    /**
//     * 方法二 动态规划DP
//     * 时间复杂度：O（mn）
//     * 空间复杂度：O（mn）
//     */
//    class Solution {
//        public int uniquePaths(int m, int n) {
//            if (n == 0 || m == 0) return 0;
//            int[][] arr = new int[m][n];
//            for (int i = 0; i < m; i++) arr[i][0] = 1;
//            for (int i = 0; i < n; i++) arr[0][i] = 1;
//            for (int i = 1; i < m; i++) { // 由于第一行都是1，所以少循环一次
//                for (int j = 1; j < n; j++) { // 由于第一列都是1，所以少循环一次
//                    arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
//                }
//            }
//            return arr[m - 1][n - 1];
//        }
//    }
//    /**
//     * 方法一 动态规划DP
//     * 使用了滚动数组
//     * 时间复杂度：O（mn）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public int uniquePaths(int m, int n) {
//            if (n == 0 || m == 0) return 0;
//            int[] arr = new int[n];
//            Arrays.fill(arr, 1);
//            for (int i = 1; i < m; i++) { // 由于第一行都是1，所以少循环一次
//                for (int j = 1; j < n; j++) { // 由于第一列都是1，所以少循环一次
//                    arr[j] += arr[j - 1];
//                }
//            }
//            return arr[n - 1];
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}