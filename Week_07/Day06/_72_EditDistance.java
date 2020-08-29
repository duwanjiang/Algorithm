//LeetCode题目: 72_编辑距离

//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划 
// 👍 1094 👎 0

package editor.cn;

public class _72_EditDistance {
    public static void main(String[] args) {
        Solution solution = new _72_EditDistance().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法二 DP的一维空间
     * 时间复杂度：O（nm）n:单词word1长度，m:单词word2长度
     * 空间复杂度：O（n）
     */
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            if (n * m == 0) return m + n; // 当任意单词为空时，步数为另一个单词长度
            int[] dp = new int[n + 1];
            // 初始化边界
            for (int i = 0; i < n + 1; i++) {
                dp[i] = i;
            }
            for (int i = 1; i < m + 1; i++) {
                int pre = dp[0];
                dp[0] = i;
                for (int j = 1; j < n + 1; j++) {
                    int temp = dp[j];
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[j] = pre;
                    else dp[j] = Math.min(pre, Math.min(dp[j - 1], dp[j])) + 1;
                    pre = temp;
                }
            }
            return dp[n];
        }
    }
//    /**
//     * 方法一 DP
//     * 时间复杂度：O（nm）n:单词word1长度，m:单词word2长度
//     * 空间复杂度：O（nm）
//     */
//    class Solution {
//        public int minDistance(String word1, String word2) {
//            int m = word1.length(), n = word2.length();
//            if (n * m == 0) return m + n; // 当任意单词为空时，步数为另一个单词长度
//            int[][] dp = new int[m + 1][n + 1];
//            // 初始化边界
//            for (int i = 0; i < m + 1; i++) {
//                dp[i][0] = i;
//            }
//            for (int i = 0; i < n + 1; i++) {
//                dp[0][i] = i;
//            }
//            for (int i = 1; i < m + 1; i++) {
//                for (int j = 1; j < n + 1; j++) {
//                    int left = dp[i - 1][j] + 1;
//                    int down = dp[i][j - 1] + 1;
//                    int leftDown = dp[i - 1][j - 1];
//                    if (word1.charAt(i - 1) != word2.charAt(j - 1)) leftDown++;
//                    dp[i][j] =  Math.min(left, Math.min(down, leftDown));
//                }
//            }
//            return dp[m][n];
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}