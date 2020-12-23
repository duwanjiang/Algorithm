//LeetCode题目: 242_有效的字母异位词

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 219 👎 0

package Week_06.Day07;

import java.util.HashMap;
import java.util.Map;

public class _242_ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new _242_ValidAnagram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法四 hash+出现次数
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null || t == null) return false;
            if (s.length() != t.length()) return false;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
            }
            for (int value : map.values()) {
                if (value != 0) return false;
            }
            return true;
        }
    }
//    /**
//     * 方法三 array+出现次数
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public boolean isAnagram(String s, String t) {
//            if(s == null || t == null) return false;
//            if(s.length() != t.length()) return false;
//            int[] chars = new int[26]; //记录26个字母
//            for (int i = 0; i < s.length(); i++) {
//                chars[s.charAt(i) - 'a']++;
//            }
//            for (int i = 0; i < t.length(); i++) {
//                chars[t.charAt(i) - 'a']--;
//                if(chars[t.charAt(i) - 'a'] < 0) return false;
//            }
//            return true;
//        }
//    }
//    /**
//     * 方法二 array+出现次数
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public boolean isAnagram(String s, String t) {
//            if(s == null || t == null) return false;
//            if(s.length() != t.length()) return false;
//            int[] chars = new int[26]; //记录26个字母
//            for (int i = 0; i < s.length(); i++) {
//                chars[s.charAt(i) - 'a']++;
//                chars[t.charAt(i) - 'a']--;
//            }
//            for (int c :chars){
//                if(c != 0) return false;
//            }
//            return true;
//        }
//    }
//    /**
//     * 方法一 暴力- 排序+对比
//     * 时间复杂度：O（NlogN）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public boolean isAnagram(String s, String t) {
//            if(s == null || t == null) return false;
//            if(s.length() != t.length()) return false;
//            char[] sChars = s.toCharArray();
//            char[] tChars = t.toCharArray();
//            Arrays.sort(sChars);
//            Arrays.sort(tChars);
//            return Arrays.equals(sChars,tChars);
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}