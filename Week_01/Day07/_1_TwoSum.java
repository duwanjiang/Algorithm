//LeetCode题目: 1_两数之和

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 8685 👎 0

package editor.cn;

import java.util.HashMap;

public class _1_TwoSum {
    public static void main(String[] args) {
        Solution solution = new _1_TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法三 hash
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums.length < 2) return new int[]{};
            HashMap<Integer, Integer> map = new HashMap<>(nums.length - 1);
            for (int i = 0; i < nums.length; i++) {
                int a = target - nums[i];
                if (map.containsKey(a)){
                    return new int[]{map.get(a), i};
                }else {
                    map.put(nums[i], i);
                }
            }
            return new int[]{};
        }
    }
//    /**
//     * 方法二 hash
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public int[] twoSum(int[] nums, int target) {
//            if (nums.length < 2) return new int[]{};
//            HashMap<Integer, Integer> map = new HashMap<>(nums.length - 1);
//            for (int i = 0; i < nums.length - 1; i++) {
//                map.put(nums[i], i);
//            }
//            for (int i = 0; i < nums.length; i++) {
//                int a = target - nums[i];
//                if (map.containsKey(a) && map.get(a) != i) return new int[]{map.get(a), i};
//            }
//            return new int[]{};
//        }
//    }
//    /**
//     * 方法一 2层循环
//     * 时间复杂度：O（n^2）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public int[] twoSum(int[] nums, int target) {
//            if (nums.length < 2) return new int[]{};
//            for (int i = 0; i < nums.length - 1; i++) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[i] + nums[j] == target) return new int[]{i, j};
//                }
//            }
//            return new int[]{};
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}