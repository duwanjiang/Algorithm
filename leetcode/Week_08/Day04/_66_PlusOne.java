//LeetCode题目: 66_加一

//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 533 👎 0

package Week_08.Day04;

public class _66_PlusOne {
    public static void main(String[] args) {
        Solution solution = new _66_PlusOne().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 迭代
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public int[] plusOne(int[] digits) {
            // 倒叙遍历，先从个位数开始进行+1计算
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] %= 10;
                if (digits[i] != 0) return digits;
            }
            // 当数组为999的进位情况时
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}