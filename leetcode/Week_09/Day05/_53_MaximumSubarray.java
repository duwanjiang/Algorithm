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
// 👍 2438 👎 0

package Week_09.Day05;

public class _53_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new _53_MaximumSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 DP
     * <p>解题思路：
     * 这里使用 sum保存最小连续子序列的和，ans保存最优子序列
     * 1、遍历数组，依次累加每个元素为sum
     * 2、当sum < 0时，表示继续累加sum只会变小，所以中断累加，sum=nums[i]
     * 3、当sum >= 0时，表示还有机会让sum变大，所以继续累加
     * 4、每次 ans = max(ans,sum)，直到最后返回ans
     * </p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            }
            if (len == 1) {
                return nums[0];
            }
            int sum = 0, ans = nums[0];
            for (int i = 0; i < len; i++) {
                if (sum < 0) {
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
                ans = Math.max(sum, ans);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}