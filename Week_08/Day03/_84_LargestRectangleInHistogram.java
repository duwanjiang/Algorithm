//LeetCode题目: 84_柱状图中最大的矩形

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 880 👎 0

package editor.cn;

import java.util.ArrayDeque;

public class _84_LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new _84_LargestRectangleInHistogram().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 栈
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int len = heights.length, maxArea = 0;
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i <= len; i++) {
                int height = i == len ? 0 : heights[i];
                // 当遇到高度在减小时，则开始出栈计算面积 LIFO
                while (!deque.isEmpty() && heights[deque.peekFirst()] > height) {
                    int cur = deque.pop();
                    int width = deque.isEmpty() ? i : i - deque.peekFirst() - 1;
                    maxArea = Math.max(maxArea, heights[cur] * width);
                }
                deque.offerFirst(i);
            }
            return maxArea;
        }
    }
//    /**
//     * 方法一 暴力法
//     * 时间复杂度：O（n^2）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public int largestRectangleArea(int[] heights) {
//            int len = heights.length;
//            if (len == 0) return 0;
//            if (len <= 1) return heights[0];
//            int maxArea = 0;
//            //计算每根柱子的最大面积
//            for (int i = 0; i < len; i++) {
//                int height = heights[i];
//                // 找到当前柱子最左侧>=height的下标
//                int left = i;
//                while (left > 0 && height <= heights[left - 1]) left--;
//                // 找到当前柱子最右侧>=height的下标
//                int right = i;
//                while (right < len - 1 && height <= heights[right + 1]) right++;
//                // 计算最大面积
//                maxArea = Math.max(maxArea, height * (right - left + 1));
//            }
//            return maxArea;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}