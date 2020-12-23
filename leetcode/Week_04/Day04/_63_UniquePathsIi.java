//LeetCode题目: 63_不同路径 II

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划 
// 👍 389 👎 0

package Week_04.Day04;

public class _63_UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new _63_UniquePathsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 动态规划
     * 使用了滚动数组
     * 时间复杂度：O（mn）
     * 空间复杂度：O（n）
     */
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
            int m = obstacleGrid.length, n = obstacleGrid[0].length;
            int[] arr = new int[n];
            arr[0] = obstacleGrid[0][0] == 0 ? 1 : 0; //初始化第一步的值，为滚动数组做基础
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) { //标记障碍物为0，并跳过
                        arr[j] = 0;
                    } else if (j > 0 && obstacleGrid[i][j - 1] == 0) { //跳过第一列，第一列默认都是1
                        arr[j] += arr[j - 1];
                    }
                }
            }
            return arr[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}