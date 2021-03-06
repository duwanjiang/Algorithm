//LeetCode题目: 127_单词接龙

//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 414 👎 0

package Week_07.Day05;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _127_WordLadder {
    public static void main(String[] args) {
        Solution solution = new _127_WordLadder().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 动态规划
     * 时间复杂度：O（mn）m:单词长度,n:单词数量
     * 空间复杂度：O（mn）
     */
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> wordSet = new HashSet<>(wordList);
            if (wordList.size() == 0 || !wordSet.contains(endWord)) return 0;
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            wordSet.remove(beginWord);
            HashSet<Object> visited = new HashSet<>();
            visited.add(beginWord);
            int len = beginWord.length(); // 单词长度
            int step = 1;
            while (!queue.isEmpty()) {
                int queueSize = queue.size();
                for (int i = 0; i < queueSize; i++) {
                    String word = queue.poll();
                    char[] chars = word.toCharArray();
                    // 遍历单词的每个字母
                    for (int j = 0; j < len; j++) {
                        char c = chars[j];
                        for (char k = 'a'; k <= 'z'; k++) { // 替换单词的每个字母
                            if (c == k) continue; // 跳过相同字符
                            chars[j] = k; // 替换新的字符
                            String newWord = String.valueOf(chars); // 获得新单词
                            if(wordSet.contains(newWord)){ // 必须是字典中单词
                                if (newWord.equals(endWord)) return step + 1;
                                if (!visited.contains(newWord)) {
                                    queue.add(newWord);
                                    visited.add(newWord);
                                }
                            }
                        }
                        chars[j] = c; // 还原单词
                    }
                }
                step++;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}