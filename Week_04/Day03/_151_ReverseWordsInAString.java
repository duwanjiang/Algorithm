//LeetCode题目: 151_翻转字符串里的单词

//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 进阶： 
//
// 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 字符串 
// 👍 203 👎 0

package editor.cn;

public class _151_ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new _151_ReverseWordsInAString().new Solution();
        solution.reverseWords("the sky is blue");
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法三 迭代
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    class Solution {
        public String reverseWords(String s) {
            if (s == null || s.trim() == "" || s.length() <= 1) return s.trim();
            String[] split = s.trim().split("\\s+");
            StringBuilder sb = new StringBuilder();
            for (int i = split.length - 1; i >= 0; i--) {
                sb.append(" ").append(split[i]);
            }
            return sb.toString().trim();
        }
    }
//    /**
//     * 方法二 语言特性
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public String reverseWords(String s) {
//            if (s == null || s.trim() == "" || s.length() <= 1) return s.trim();
//            List<String> list = Arrays.asList(s.trim().split("\\s+"));
//            Collections.reverse(list);
//            return String.join(" ", list);
//        }
//    }
//    /**
//     * 方法一 栈
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public String reverseWords(String s) {
//            if (s == null || s.trim() == "" || s.length() <= 1) return s.trim();
//            String[] strs = s.split(" ");
//            LinkedList<String> deque = new LinkedList<>();
//            for (String str : strs) {
//                if (str.length() > 0) deque.addFirst(str);
//            }
//            StringBuilder sb = new StringBuilder();
//            int size = deque.size();
//            for (int i = 0; i < size; i++) {
//                sb.append(deque.poll()).append(" ");
//            }
//            return sb.toString().trim();
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}