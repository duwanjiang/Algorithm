//LeetCode题目: 17_电话号码的字母组合

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 809 👎 0

package Week_03.Day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new _17_LetterCombinationsOfAPhoneNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 回溯
     * 时间复杂度：O（3^n*4^m）
     * 空间复杂度：O（3^n*4^m）
     */
    class Solution {
        public List<String> letterCombinations(String digits) {
            ArrayList<String> list = new ArrayList<>();
            if (digits.length() == 0) return list;
            HashMap<String, String> map = new HashMap<String, String>() {{
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
            }};
            divideConquer("", map, digits, list);
            return list;
        }

        private void divideConquer(String combination, HashMap<String, String> map, String nextDigit, ArrayList<String> list) {
            if (nextDigit.length() == 0) {
                list.add(combination); // 当拼接完成后，输出结果
            } else {
                String letter = map.get(nextDigit.substring(0, 1)); //获取第一个数字的字母
                for (int i = 0; i < letter.length(); i++) {
                    divideConquer(combination + letter.charAt(i), map, nextDigit.substring(1), list); //没一个字母+下一个数字的字母
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}