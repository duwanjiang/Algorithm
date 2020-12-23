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
// 👍 1128 👎 0

package Week_01.Day03;

public class _70_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new _70_ClimbingStairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法六 动态规划-单循环-简洁版
     * 斐波拉契数列的计算
     */
    class Solution {
        public int climbStairs(int n) {
            if (n < 3) return n;
            //使用变量记录之前的2步结果
            int pre = 1;
            int result = 2;
            for (int k = 2; k < n; k++) {
                pre = (result += pre) - pre;
            }
            return result;
        }
    }

//    /**
//     * 方法五 暴力递归-缓存
//     * 斐波拉契数列的计算
//     */
//    class Solution {
//        public int climbStairs(int n) {
//            Map<Integer, Integer> map = new HashMap<>();
//            return climbStairsRecur(n, map);
//        }
//
//        private int climbStairsRecur(int n, Map<Integer, Integer> map) {
//            if (n < 3) return n;
//            if (map.containsKey(n)) return map.get(n);
//            int m = climbStairsRecur(n - 1, map) + climbStairsRecur(n - 2, map);
//            map.put(n, m);
//            return m;
//        }
//    }

//    /**
//     * 方法四 使用公式
//     * fn=[((1 + Math.sqrt(5))/2)^n+1 - ((1 - Math.sqrt(5))/2)^n+1] / Math.sqrt(5)
//     * 斐波拉契数列的计算
//     */
//    class Solution {
//        public int climbStairs(int n) {
//            double sqrt_5 = Math.sqrt(5);
//            double fn = (Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2, n + 1));
//            return (int) (fn / sqrt_5);
//        }
//    }

//    /**
//     * 方法三 动态规划-单循环 降低空间维度
//     * 斐波拉契数列的计算
//     */
//    class Solution {
//        public int climbStairs(int n) {
//            if (n < 3) return n;
//            //使用变量记录之前的2步结果
//            int i = 1;
//            int j = 2;
//            int result = 0;
//            for (int k = 2; k < n; k++) {
//                result = i + j;
//                i = j;
//                j = result;
//            }
//            return result;
//        }
//    }

//    /**
//     * 方法二 动态规划-缓存数组
//     * 斐波拉契数列的计算
//     */
//    class Solution {
//        public int climbStairs(int n) {
//            if (n < 2) return n;
//            //使用数组将每步都记录下来
//            int[] dp = new int[n];
//            dp[0] = 1;
//            dp[1] = 2;
//            for (int i = 2; i < n; i++) {
//                dp[i] = dp[i - 1] + dp[i - 2];
//            }
//            return dp[n - 1];
//        }
//    }

//    /**
//     * 方法一 暴力递归
//     * 斐波拉契数列的计算
//     */
//    class Solution {
//        public int climbStairs(int n) {
//            if (n < 3) {
//                return n;
//            }
//            return climbStairs(n - 1) + climbStairs(n - 2);
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}