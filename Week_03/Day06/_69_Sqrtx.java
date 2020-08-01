//LeetCode题目: 69_x 的平方根

//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 459 👎 0

package editor.cn;

public class _69_Sqrtx {
    public static void main(String[] args) {
        Solution solution = new _69_Sqrtx().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法二 牛顿迭代
     * 时间复杂度：O（logn）
     * 空间复杂度：O（1）
     */
    class Solution {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) return x;
            long a = x;
            while (a * a > x) {
                a = (a + x / a) / 2;
            }
            return (int) a;
        }
    }
//
//    /**
//     * 方法一 二分查找
//     * 1. 单调递增
//     * 2. 有边界
//     * 3. index
//     * 时间复杂度：O（logn）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public int mySqrt(int x) {
//            if (x == 0 || x == 1) return x;
//            long left = 0, right = x, ans = 0;
//            while (left <= right) {
//                long mid = left + (right - left) / 2;
//                if (x >= mid * mid) {
//                    ans = mid;
//                    left = mid + 1;
//                } else right = mid - 1;
//            }
//            return (int) ans;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}