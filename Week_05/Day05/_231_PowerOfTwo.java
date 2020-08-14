//LeetCode题目: 231_2的幂

//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 232 👎 0

package editor.cn;

public class _231_PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new _231_PowerOfTwo().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 位运算
     * 2的幂二进制表示只会包含一个1
     * 时间复杂度：O（1）
     * 空间复杂度：O（1）
     */
    class Solution {
        public boolean isPowerOfTwo(int n) {
            return n == 0 ? false : (n & ((long)n - 1)) == 0; // 防止溢出
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}