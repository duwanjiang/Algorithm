//LeetCode题目: 20_有效的括号

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1695 👎 0

package Week_01.Day06;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new _20_ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 stack
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    class Solution {
        public boolean isValid(String s) {
            if (s == null) return false;
            if (s.length() == 0) return true;
            Stack<Character> stack = new Stack<>();
            Map<Character, Character> map = new HashMap();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (map.containsKey(c)) {
                    Character top = stack.isEmpty() ? '$' : stack.pop();
                    if (!top.equals(map.get(c))) {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}