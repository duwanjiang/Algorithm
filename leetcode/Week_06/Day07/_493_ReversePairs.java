//LeetCode题目: 493_翻转对

//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 123 👎 0

package Week_06.Day07;

public class _493_ReversePairs {
    public static void main(String[] args) {
        Solution solution = new _493_ReversePairs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 归并排序
     * 时间复杂度：O（nlogn）
     * 空间复杂度：O（n）
     */
    class Solution {
        public int reversePairs(int[] nums) {
            return reversePairsSub(nums, 0, nums.length - 1);
        }

        private int reversePairsSub(int[] nums, int l, int r) {
            if (l >= r) return 0;
            int m = l + ((r - l) >> 1);
            int res = reversePairsSub(nums, l, m) + reversePairsSub(nums, m + 1, r);

            int i = l, j = m + 1, k = 0, p = m + 1;
            int[] merge = new int[r - l + 1];
            while (i <= m) {
                while (p <= r && nums[i] > 2L * nums[p]) p++;
                res += p - (m + 1);
                while (j <= r && nums[i] >= nums[j]) merge[k++] = nums[j++];
                merge[k++] = nums[i++];
            }
            while (j <= r) merge[k++] = nums[j++];
            System.arraycopy(merge, 0, nums, l, merge.length);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}