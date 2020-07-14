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

package com.cloud._40_algorithm.leetcode.editor.cn;

public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法四：使用公式
     * 可知本题是斐波那契数列
     * f(n) = [(1 + Math.sqrt(5)/2)^n - ((1 - Math.sqrt(5))/2)^n] / Math.sqrt(5)
     */
    class Solution {
        public int climbStairs(int n) {
            double sqrt5 = Math.sqrt(5);
            double fibn = Math.pow(((1 + Math.sqrt(5)) / 2), n + 1) - Math.pow(((1 - Math.sqrt(5)) / 2), n + 1);
            return (int) (fibn / sqrt5);
        }
    }

//    /**
//     * 方法三：动态规划
//     * 可知本题是斐波那契数列
//     * f(n) = f(n-1)+f(n-2)
//     */
//    class Solution {
//        public int climbStairs(int n) {
//            //f(n) = f(n-1)+f(n-2)
//            if (n == 1) return 1;
//            if (n == 2) return 2;
//            int i = 1; //f(n-2)
//            int j = 2; //f(n-1)
//            int result = 0;
//            for (int k = 3; k < n; k++) {
//                result = j + i;
//                i = j;
//                j = result;
//            }
//            return result;
//        }
//    }

//    /**
//     * 方法二：暴力算法，递归函数-有缓存
    // TODO: 2020/7/14 0014 还未完成
//     */
//    class Solution {
//        public int climbStairs(int n) {
//            //f(n) = f(n-1)+f(n-2)
//            if (n == 1) return 1;
//            if (n == 2) return 2;
//            int[][] temp = new int[n - 1][1];
//            return climbStairsRecur(n, temp);
//        }
//
//        public int climbStairsRecur(int n, int[][] temp) {
//            //f(n) = f(n-1)+f(n-2)
//            if(temp[n][0] == 0){
//                temp[n][0] = climbStairs(n - 1) + climbStairs(n - 2);
//            }else{
//                return temp[n][0];
//            }
//            return temp[n][0];
//        }
//    }

//    /**
//     * 方法一：暴力算法，递归函数-无缓存
//     */
//    class Solution {
//        public int climbStairs(int n) {
//            //f(n) = f(n-1)+f(n-2)
//            if (n == 1) return 1;
//            if (n == 2) return 2;
//            return climbStairs(n - 1) + climbStairs(n - 2);
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}