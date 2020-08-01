//LeetCode题目: 455_分发饼干

//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干
//的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满
//足越多数量的孩子，并输出这个最大数值。 
//
// 注意： 
//
// 你可以假设胃口值为正。 
//一个小朋友最多只能拥有一块饼干。 
//
// 示例 1: 
//
// 
//输入: [1,2,3], [1,1]
//
//输出: 1
//
//解释: 
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
// 
//
// 示例 2: 
//
// 
//输入: [1,2], [1,2,3]
//
//输出: 2
//
//解释: 
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
// 
// Related Topics 贪心算法 
// 👍 188 👎 0

package editor.cn;

import java.util.Arrays;

public class _455_AssignCookies {
    public static void main(String[] args) {
        Solution solution = new _455_AssignCookies().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 贪心法-迭代
     * 1. 先满足胃口最小的孩子，才能达到最先满足，所以先排序
     * 2. 同时遍历2个数组，当满足孩子胃口时，2个数组同时加1
     * 3. 当不满足时，只需要饼干数组加1
     * 时间复杂度：O（nlogn）
     * 空间复杂度：O（nlogn）
     */
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            if (g.length == 0 || s.length == 0) return 0;
            int i = 0, j = 0;
            Arrays.sort(g);
            Arrays.sort(s);
            while (i < g.length && j < s.length) {
                if (g[i] <= s[j]) {
                    i++;
                } else {
                    j++;
                }
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}