//LeetCode题目: 152_乘积最大子数组

//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 692 👎 0

package editor.cn;

public class _152_MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new _152_MaximumProductSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 DP动态规划
     * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
     * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。
     * 因此还需要维护当前最小值 imin = min(imin * nums[i], nums[i])
     * <p>
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    class Solution {
        public int maxProduct(int[] nums) {
            //1. 分治子问题 sub_max[i] = max(sub_max[i-1] * a[i], a[i])
            //2. 状态数组 f[i]
            //3. DP方程 f[i] = max(f[i-1] * a[i], a[i])
            if (nums.length == 0) return 0;
            int max = Integer.MIN_VALUE, imin = 1, imax = 1; //1乘以任何数都是本省
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    int temp = imax;
                    imax = imin;
                    imin = temp;
                }
                imax = Math.max(imax * nums[i], nums[i]);
                imin = Math.min(imin * nums[i], nums[i]);
                max = Math.max(max, imax);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}