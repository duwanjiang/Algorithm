//LeetCode题目: 22_括号生成

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1190 👎 0

package Week_02.Day07;

import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParentheses {
    public static void main(String[] args) {
        _22_GenerateParentheses generateParentheses = new _22_GenerateParentheses();
        Solution solution = generateParentheses.new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 递归
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public List<String> generateParenthesis(int n) {
            ArrayList<String> list = new ArrayList<>();
            if (n == 0) return list;
            helper(0, 0, list, "", n);
            return list;
        }

        private void helper(int left, int right, List<String> list, String s, int n) {
            //终止条件
            if (left == n && right == n) {
                list.add(s);
                return;
            }
            //处理流程
            if (left < n) helper(left + 1, right, list, s + "(", n);
            if (right < left) helper(left, right + 1, list, s + ")", n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}