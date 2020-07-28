//LeetCode题目: 50_Pow(x, n)

//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找 
// 👍 453 👎 0

package editor.cn;

public class _50_PowxN {
    public static void main(String[] args) {
        Solution solution = new _50_PowxN().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

//    /**
//     * 方法三 迭代
//     * 分治法，寻找子问题
//     * 时间复杂度：O（logn）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public double myPow(double x, int n) {
//            long N = n; //如果n=−2147483648，执行-n就会出现越界
//            if (x == 0) return 0;
//            if (N == 0) return 1.0;
//            return N > 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
//        }
//
//        /**
//         * 当n为偶数时，x^n=(x*x)^(n/2)
//         * 当n为基数时，x^n=x*(x*x)^(n/2)
//         *
//         * @param x
//         * @param n
//         * @return
//         */
//        double quickMul(double x, long n) {
//            double ans = 1.0;
//            while (n > 0) {
//                if (n % 2 == 1) { //表示为基数时，应该多乘一次x
//                    ans *= x;
//                }
//                x *= x;
//                n = n >> 1;
//            }
//            return ans;
//        }
//    }

    /**
     * 方法二 递归-简版
     * 分治法，寻找子问题
     * 时间复杂度：O（logn）
     * 空间复杂度：O（logn）
     */
    class Solution {
        public double myPow(double x, int n) {
            if (n == 0) return 1.0;
            double res = myPow(x, n / 2);
            return n % 2 == 0 ? res * res : n < 0 ? res * res * (1 / x) : res * res * x;
        }
    }
//    /**
//     * 方法一 递归
//     * 分治法，寻找子问题
//     * 时间复杂度：O（logn）
//     * 空间复杂度：O（logn）
//     */
//    class Solution {
//        public double myPow(double x, int n) {
//            long N = n;//如果n=−2147483648，执行-n就会出现越界,所以需要为long型
//            if (N == 0) return 1.0;
//            if (N < 0) {
//                N = -N;
//                x = 1 / x;
//            }
//            return divideConquer(x, N);
//        }
//
//        private double divideConquer(double x, long n) {
//            //终止条件
//            if(n == 0) return 1.0;
//            return n % 2 == 0 ? divideConquer(x * x, n / 2) : x * divideConquer(x * x, n / 2);
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}