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
// 👍 805 👎 0

package Week_01.Day07;

import java.util.ArrayDeque;
import java.util.Deque;

public class _84_LargestRectangleInHistogram {
    public static void main(String[] args) {
        _84_LargestRectangleInHistogram largestRectangleInHistogram = new _84_LargestRectangleInHistogram();
        Solution solution = largestRectangleInHistogram.new Solution();
        int[] heights = new int[]{1, 1};
        solution.largestRectangleArea(heights);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

//    /**
//     * 方法三 array-模拟栈
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public int largestRectangleArea(int[] heights) {
//            int res = 0;
//            int[] stack = new int[heights.length + 1];
//            int index = -1;
//            //通过栈来存储右边边界，即height[i]>=height[i+1]
//            for (int i = 0; i <= heights.length; i++) {
//                int height = (i == heights.length) ? 0 : heights[i];
//                //当到达右边边界时,依次计算从最大高度到最低高度的面积，随着高度较低，宽度也会同时增加
//                while (index != -1 && heights[stack[index]] > height) {
//                    int curHeight = heights[stack[index--]];
//                    int width = index == -1 ? i : i - stack[index] - 1;
//                    res = Math.max(res, width * curHeight);
//                }
//                stack[++index] = i;
//            }
//            return res;
//        }
//    }

    /**
     * 方法二 栈
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int res = 0;
            Deque<Integer> stack = new ArrayDeque<>();
            //为了便于用同一公式计算宽度
            //通过栈来存储右边边界，即height[i]>=height[i+1]
            for (int i = 0; i <= heights.length; i++) {
                int height = i == heights.length ? 0 : heights[i]; //防止下标越界
                //当到达右边边界时,依次计算从最大高度到最低高度的面积，随着高度较低，宽度也会同时增加
                while (!stack.isEmpty() && heights[stack.peek()] > height) {
                    int cur = stack.pop();
                    int width = stack.isEmpty() ? i : i - stack.peekFirst() - 1;
                    res = Math.max(res, width * heights[cur]);
                }
                stack.push(i);
            }
            return res;
        }
    }
//    /**
//     * 方法一 暴力求解
//     * 时间复杂度：O（n^2）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public int largestRectangleArea(int[] heights) {
//            if (heights.length == 0) return 0;
//            int maxArea = 0;
//            for (int i = 0; i < heights.length; i++) {
//                int height = heights[i];
//                //向右找当大于等于当前柱子高的下标
//                int right = i;
//                while (right < heights.length - 1 && height <= heights[right + 1]) right++;
//                //向左找当大于等于当前柱子高的下标
//                int left = i;
//                while (left > 0 && height <= heights[left - 1]) left--;
//                int width = right - left + 1;
//                maxArea = Math.max(maxArea, width * height);
//            }
//            return maxArea;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}