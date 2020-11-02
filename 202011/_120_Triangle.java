//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 630 👎 0

package editor.cn;

import java.util.List;

public class _120_Triangle {
    public static void main(String[] args) {
        Solution solution = new _120_Triangle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法三 DP（简洁代码）
     * 自底向上的DP：minpath[k][i] = min( minpath[k+1][i], minpath[k+1][i+1]) + triangle[k][i];
     * 时间复杂度：O（mn）
     * 空间复杂度：O（n）
     */
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] f = new int[triangle.size() + 1];
            for (int i = triangle.size() - 1; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    f[j] = Math.min(f[j + 1], f[j]) + triangle.get(i).get(j);
                }
            }
            return f[0];
        }
    }
//    /**
//     * 方法二 DP + 空间优化
//     * 时间复杂度：O（mn）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public int minimumTotal(List<List<Integer>> triangle) {
//            int n = triangle.size();
//            if (n < 1) return 0;
//            int[] f = new int[n];
//            f[0] = triangle.get(0).get(0);
//            for (int i = 1; i < n; i++) {
//                // 需要倒叙，防止上一层值被覆盖
//                f[i] = f[i - 1] + triangle.get(i).get(i);
//                for (int j = i - 1; j > 0; j--) {
//                    f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
//                }
//                f[0] = f[0] + triangle.get(i).get(0);
//            }
//
//            int min = f[0];
//            for (int i = 1; i < n; i++) {
//                min = Math.min(min, f[i]);
//            }
//            return min;
//        }
//    }
//    /**
//     * 方法一 DP
//     * 时间复杂度：O（mn）
//     * 空间复杂度：O（mn）
//     */
//    class Solution {
//        public int minimumTotal(List<List<Integer>> triangle) {
//            int n = triangle.size();
//            if (n < 1) return 0;
//            int[][] f = new int[n][n];
//            f[0][0] = triangle.get(0).get(0);
//            for (int i = 1; i < n; i++) {
//                f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
//                for (int j = 1; j < i; j++) {
//                    f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
//                }
//                f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
//            }
//
//            int min = f[n - 1][0];
//            for (int i = 0; i < n; i++) {
//                min = Math.min(min, f[n - 1][i]);
//            }
//            return min;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}