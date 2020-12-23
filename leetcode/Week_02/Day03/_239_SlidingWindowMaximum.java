//LeetCode题目: 239_滑动窗口最大值

//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 460 👎 0

package Week_02.Day03;

import java.util.LinkedList;

public class _239_SlidingWindowMaximum {
    public static void main(String[] args) {
        _239_SlidingWindowMaximum slidingWindowMaximum = new _239_SlidingWindowMaximum();
        Solution solution = slidingWindowMaximum.new Solution();
        solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

//    /**
//     * 方法三 动态规划
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//
//        public int[] maxSlidingWindow(int[] nums, int k) {
//            if (nums.length == 0 || k == 0) return new int[0];
//            if (nums.length == 1) return nums;
//            int n = nums.length;
//            int[] output = new int[n - k + 1];
//            int[] left = new int[n];
//            left[0] = nums[0];
//            int[] right = new int[n];
//            right[n - 1] = nums[n - 1];
//            for (int i = 1; i < n; i++) {
//                //从左到右遍历
//                if (i % k == 0) left[i] = nums[i]; //左到右的每个块的开始位置，重新复制
//                else left[i] = Math.max(left[i - 1], nums[i]);
//                //从右到做遍历
//                int j = n - i - 1;
//                if ((j + 1) % k == 0) right[j] = nums[j]; //右到左的每个块边界
//                else right[j] = Math.max(right[j + 1], nums[j]);
//            }
//            //依次遍历k之后的元素
//            for (int i = 0; i < n - k + 1; i++) {
//                output[i] = Math.max(left[k + i - 1], right[i]);
//            }
//            return output;
//        }
//    }

    /**
     * 方法二 双端队列
     * 最佳时间
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k == 0) return new int[0];
            if (nums.length == 1) return nums;
            int n = nums.length;
            LinkedList<Integer> deque = new LinkedList<>(); //存储最大值下标
            int[] output = new int[n - k + 1];
            for (int i = 0; i < n; i++) {
                //移除窗口之外，即：小于i-k+1的元素
                while (!deque.isEmpty() && i - k + 1 > deque.peek()) deque.pollFirst();
                //移除队列中比i元素小的所有元素
                while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) deque.pollLast();
                deque.offer(i);
                //将最大值放入结果数组
                if (i - k + 1 >= 0) output[i - k + 1] = nums[deque.peek()];
            }
            return output;
        }
    }
//    /**
//     * 方法一 暴力2层迭代
//     * 时间复杂度：O（NK）
//     * 空间复杂度：O（N - K + 1）
//     */
//    class Solution {
//        public int[] maxSlidingWindow(int[] nums, int k) {
//            if (nums.length == 0 || k == 0) return new int[0];
//            if (nums.length == 1) return nums;
//            int n = nums.length;
//            int[] output = new int[n - k + 1];
//            for (int i = 0; i < n - k + 1; i++) {
//                int max = nums[i];
//                for (int j = i; j < i + k; j++) {
//                    max = Math.max(max, nums[j]);
//                }
//                output[i] = max;
//            }
//            return output;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}