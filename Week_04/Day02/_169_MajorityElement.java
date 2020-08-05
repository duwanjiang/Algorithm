//LeetCode题目: 169_多数元素

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 686 👎 0

package editor.cn;

public class _169_MajorityElement {
    public static void main(String[] args) {
        Solution solution = new _169_MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法四 迭代
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    class Solution {
        public int majorityElement(int[] nums) {
            if (nums.length == 1) return nums[0];
            int max = nums[0], count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (count == 0) {
                    max = nums[i];
                    count++;
                } else if (max == nums[i]) {
                    count++;
                } else count--;
            }
            return max;
        }
    }
//    /**
//     * 方法三 分治
//     * 时间复杂度：O（nlogn）
//     * 空间复杂度：O（logn）
//     */
//    class Solution {
//        public int majorityElement(int[] nums) {
//            return divideConquer(nums, 0, nums.length - 1);
//        }
//
//        private int divideConquer(int[] nums, int lo, int hi) {
//            if (lo == hi) return nums[lo]; //终止条件
//            //将数组拆分为左右子数组，即左右子问题
//            int mid = (hi - lo) / 2 + lo;
//            int left = divideConquer(nums, lo, mid);
//            int right = divideConquer(nums, mid + 1, hi);
//            if (left == right) {
//                return left;
//            }
//            //计算左右子数组中的众数在整个数组中出现的次数
//            int leftCount = numsCount(nums, left, lo, hi);
//            int rightCount = numsCount(nums, right, lo, hi);
//            return leftCount > rightCount ? left : right;
//        }
//
//        private int numsCount(int[] nums, int left, int lo, int hi) {
//            int count = 0;
//            for (int i = lo; i <= hi; i++) {
//                if (nums[i] == left) count++;
//            }
//            return count;
//        }
//    }
//    /**
//     * 方法二 排序
//     * 时间复杂度：O（nlogn）
//     * 空间复杂度：O（logn）
//     */
//    class Solution {
//        public int majorityElement(int[] nums) {
//            Arrays.sort(nums);
//            return nums[nums.length >> 1];
//        }
//    }
//
//    /**
//     * 方法一 hash
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public int majorityElement(int[] nums) {
//            if (nums.length == 0) return 0;
//            HashMap<Integer, Integer> map = new HashMap<>();
//            for (Integer num : nums) {
//                map.put(num, map.getOrDefault(num, 0) + 1);
//            }
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                if (entry.getValue() > nums.length / 2) {
//                    return entry.getKey();
//                }
//            }
//            return 0;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}