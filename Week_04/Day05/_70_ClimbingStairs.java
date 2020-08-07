//LeetCode题目: 70_爬楼梯

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1181 👎 0

package editor.cn;

public class _70_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new _70_ClimbingStairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法二 公式
     * fn = 1/sqrt5 * [((1+sqrt5)/2)^(n+1) - ((1-sqrt5)/2)^(n+1)]
     * 时间复杂度：O（1）
     * 空间复杂度：O（1）
     */
    class Solution {
        public int climbStairs(int n) {
            if (n <= 2) return n;
            double sqrt5 = Math.sqrt(5);
            double fn = (Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1)) / sqrt5;
            return (int) fn;
        }
    }
//    /**
//     * 方法一 动态规划
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public int climbStairs(int n) {
//            if (n <= 2) return n;
//            int p1 = 1, p2 = 2;
//            for (int i = 2; i < n; i++) {
//                int temp = p2;
//                p2 = p1 + p2;
//                p1 = temp;
//            }
//            return p2;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}