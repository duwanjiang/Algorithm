//LeetCode题目: 53_最大子序和

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2272 👎 0

package editor.cn;

public class _53_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new _53_MaximumSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法二 DP动态规划
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            //如果 preMax > 0，则说明 preMax 对结果有增益效果，则 preMax 保留并加上当前遍历数字
            //如果 preMax <= 0，则说明 preMax 对结果无增益效果，需要舍弃，则 preMax 直接更新为当前遍历数字
            if (nums.length == 0) return 0;
            int preMax = 0, ansMax = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (preMax > 0) {
                    preMax += nums[i];
                } else {
                    preMax = nums[i];
                }
                ansMax = Math.max(preMax, ansMax);
            }
            return ansMax;
        }
    }
//    /**
//     * 方法一 DP动态规划
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public int maxSubArray(int[] nums) {
//            //1. 分治子问题 max_sub[i] = max(max_sub[i-1],0) + a[i]
//            //2. 定义状态数组 f[i]
//            //3. DP方程 dp[i] = max(dp[i-1] + a[i], a[i])
//            if (nums.length == 0) return 0;
//            int[] dp = nums;
//            for (int i = 1; i < nums.length; i++) {
//                dp[i] = Math.max(dp[i - 1], 0) + nums[i];
//            }
//            int max = dp[0];
//            for (int i = 1; i < nums.length; i++) {
//                max = Math.max(max, dp[i]);
//            }
//            return max;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}