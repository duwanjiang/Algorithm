//LeetCode题目: 49_字母异位词分组

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 396 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class _49_GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new _49_GroupAnagrams().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法二 array + 计数分类
     * 时间复杂度：O（NK）
     * 空间复杂度：O（NK）
     */
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length <= 0) return Collections.emptyList();
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                int[] count = new int[26];
                //这里利用异位词中相同的字母-'a'得到相同数字，即数组下标相同，从而得到count数组相同
                for (char c : str.toCharArray()) count[c - 'a']++;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < count.length; i++) {
                    sb.append(count[i]);
                }
                String key = sb.toString(); //所以这里的异位词的key相同
                if (!map.containsKey(key)) map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
//    /**
//     * 方法一 排序+hash
//     * 时间复杂度：O（NKlogK）
//     * 空间复杂度：O（NK）
//     */
//    class Solution {
//        public List<List<String>> groupAnagrams(String[] strs) {
//            if (strs == null || strs.length <= 0) return Collections.emptyList();
//            HashMap<String, List<String>> map = new HashMap<>();
//            for (String str : strs) {
//                //对每个单词排序，并放入hash的key进行存储
//                char[] chars = str.toCharArray();
//                Arrays.sort(chars);
//                String key = String.valueOf(chars);
//                if (!map.containsKey(key)) map.put(key, new ArrayList<>());
//                map.get(key).add(str);
//            }
//            return new ArrayList<>(map.values());
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}