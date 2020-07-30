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
// 👍 454 👎 0

package editor.cn;

public class _50_PowxN {
    public static void main(String[] args) {
        Solution solution = new _50_PowxN().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 分治
     * if n = 偶数 then x^n = x^(n/2) * x^(n/2)
     * if n = 基数 then x^n = x^(n/2) * x^(n/2) * x
     * 时间复杂度：O（logn）
     * 空间复杂度：O（logn）
     */
    class Solution {
        public double myPow(double x, int n) {
            if (x == 0) return 0;
            if (n == 0) return 1;
            double res = myPow(x, n / 2);
            return n % 2 == 0 ? res * res : n > 0 ? x * res * res : (1 / x) * res * res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}