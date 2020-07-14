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
// 👍 8630 👎 0

package com.cloud._40_algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法三：1遍hash表 O(n)
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap();
            // 在将元素放入hash表的同时，进行数据判断
            // 检查num[i] =target - map.get(target-num[i])
            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (map.containsKey(temp)) {
                    return new int[]{map.get(temp), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }

//    /**
//     * 方法二：2遍hash表 O(n)
//     */
//    class Solution {
//        public int[] twoSum(int[] nums, int target) {
//            Map<Integer, Integer> map = new HashMap();
//            // 将所有元素先放入hash表
//            for (int i = 0; i < nums.length; i++) {
//                map.put(nums[i], i);
//            }
//
//            // 检查num[i] =target - map.get(target-num[i])
//            for (int j = 0; j < nums.length; j++) {
//                int temp = target - nums[j];
//                if (map.containsKey(temp) && map.get(temp) != j) {
//                    return new int[]{map.get(temp), j};
//                }
//            }
//            throw new IllegalArgumentException("No two sum solution");
//        }
//    }

//leetcode submit region end(Prohibit modification and deletion)

//    /**
//     * 方法一：双重循环暴力法 O(n^2)
//     */
//    class Solution {
//        public int[] twoSum(int[] nums, int target) {
//            for (int i = 0; i < nums.length - 1; i++) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[i] + nums[j] == target) {
//                        return new int[]{i, j};
//                    }
//                }
//            }
//            throw new IllegalArgumentException("No two sum solution");
//        }
//    }
}