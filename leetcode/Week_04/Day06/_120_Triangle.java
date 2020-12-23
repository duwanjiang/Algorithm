//LeetCode题目: 120_三角形最小路径和

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
// 👍 560 👎 0

package Week_04.Day06;

import java.util.List;

public class _120_Triangle {
    public static void main(String[] args) {
        Solution solution = new _120_Triangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 DP动态规划
     * 自底向上
     * 时间复杂度：O（n^2）
     * 空间复杂度：O（n）
     */
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            //1. 分治（子问题）problem[i][j] = min(sub[i+1][j+1], sub[i+1][j]) + a[i][j]
            //2. 状态数组定义 f[i][j]
            //3. DP方程 f[i][j] = min(f[i+1][j+1],f[i+1][j]) + a[i][j]
            if (triangle.size() == 0) return 0;
            int[] arr = new int[triangle.size() + 1];
            for (int i = triangle.size() - 1; i >= 0; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    arr[j] = Math.min(arr[j], arr[j + 1]) + triangle.get(i).get(j); //自己加下一层的最小值
                }
            }
            return arr[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}