//LeetCode题目: 33_搜索旋转排序数组

//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找 
// 👍 857 👎 0

package Week_03.Day07;

public class _33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new _33_SearchInRotatedSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 二分查找
     * 时间复杂度：O（logn）
     * 空间复杂度：O（1）
     */
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0) return -1;
            if (nums.length == 1) return nums[0] == target ? 0 : -1;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (nums[mid] == target) return mid;
                if (nums[0] <= nums[mid]) {
                    if (nums[0] <= target && target < nums[mid]) right = mid - 1;
                    else left = mid + 1;
                } else {
                    if (nums[mid] < target && target <= nums[nums.length - 1]) left = mid + 1;
                    else right = mid - 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}