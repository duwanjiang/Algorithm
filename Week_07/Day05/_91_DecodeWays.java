//LeetCode题目: 91_解码方法

//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划 
// 👍 486 👎 0

package editor.cn;

public class _91_DecodeWays {
    public static void main(String[] args) {
        Solution solution = new _91_DecodeWays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 动态规划
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    class Solution {
        public int numDecodings(String s) {
            int len = s.length();
            if (len == 0) return 0;
            char[] chars = s.toCharArray();
            if (chars[0] == '0') return 0; // 首字母不能为0,因为无法解析
            int cur = 1, pre = 1;
            for (int i = 1; i < len; i++) {
                int temp = cur;
                if (chars[i] == '0') {
                    if (chars[i - 1] == '1' || chars[i - 1] == '2') cur = pre;
                    else return 0;
                } else if (chars[i - 1] == '1'
                        || (chars[i - 1] == '2' && chars[i] >= '1' && chars[i] <= '6'))
                    cur += pre;
                pre = temp;
            }
            return cur;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}