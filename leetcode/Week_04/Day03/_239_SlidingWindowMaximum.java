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
// 👍 484 👎 0

package Week_04.Day03;

public class _239_SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new _239_SlidingWindowMaximum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法三 动态规划
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length <= 1 || k <= 1) return nums;
            int[] output = new int[nums.length - k + 1];
            int[] left = new int[nums.length], right = new int[nums.length];
            left[0] = nums[0];
            right[0] = nums[nums.length - 1];
            for (int i = 1; i < nums.length; i++) {
                //从左到右遍历
                if (i % k == 0) left[i] = nums[i];
                else left[i] = Math.max(left[i - 1], nums[i]);
                //从右到做遍历
                int j = nums.length - i - 1;
                if ((j + 1) % k == 0) right[j] = nums[j];
                else right[j] = Math.max(right[j + 1], nums[j]);
            }
            for (int i = 0; i < nums.length - k + 1; i++) {
                output[i] = Math.max(left[i + k - 1], right[i]); //取滑动窗口的一头一尾最大值
            }
            return output;
        }
    }
//    /**
//     * 方法二 双端队列
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public int[] maxSlidingWindow(int[] nums, int k) {
//            if (nums.length <= 1 || k <= 1) return nums;
//            LinkedList<Integer> deque = new LinkedList<>();
//            int[] output = new int[nums.length - k + 1];
//            for (int i = 0; i < nums.length; i++) {
//                //移除队首小于i-k+1的元素，即窗口外元素
//                while (!deque.isEmpty() && i - k + 1 > deque.peekFirst()) deque.pollFirst();
//                //移除队尾中小于i的元素
//                while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) deque.pollLast();
//                deque.offerLast(i); //添加到队尾
//                //将队首的最大元素放入输出数组
//                if (i - k + 1 >= 0) output[i - k + 1] = nums[deque.peekFirst()];
//            }
//            return output;
//        }
//    }
//    /**
//     * 方法一 暴力2层迭代
//     * 时间复杂度：O（NK）
//     * 空间复杂度：O（N - K + 1）
//     */
//    class Solution {
//        public int[] maxSlidingWindow(int[] nums, int k) {
//            if (nums.length <= 1 || k <= 1) return nums;
//            int outputCount = nums.length - k + 1;
//            int[] output = new int[outputCount];
//            for (int i = 0; i < outputCount; i++) {
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