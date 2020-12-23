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
// 👍 8642 👎 0

package Week_01.Day03;

import java.util.HashMap;

public class _1_TwoSum {
    public static void main(String[] args) {
        Solution solution = new _1_TwoSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法三 一遍hash表，边放边比较
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            //一边将元素放入hash表中，
            //一边判断 是否 获取hash表中的对应元素=target - nums[i] 且 i != hash中存储元素的索引
            HashMap<Integer, Integer> map = new HashMap();
            for (int i = 1; i < nums.length; i++) {
                map.put(nums[i - 1], i - 1);
                int key = target - nums[i];
                if (map.containsKey(key)) {
                    return new int[]{i, map.get(key)};
                }
            }

            throw new IllegalArgumentException("参数错误");
        }
    }
//    /**
//     * 方法二 两遍hash表
//     */
//    class Solution {
//        public int[] twoSum(int[] nums, int target) {
//            //将所有元素放入hash表中
//            HashMap<Integer, Integer> map = new HashMap();
//            for (int i = 0; i < nums.length; i++) {
//                map.put(nums[i], i);
//            }
//            //获取hash表中的对应元素=target - nums[i] 且 i != hash中存储元素的索引
//            for (int i = 0; i < nums.length - 1; i++) {
//                int key = target - nums[i];
//                if (map.containsKey(key) && map.get(key) != i) {
//                    return new int[]{i, map.get(key)};
//                }
//            }
//            throw new IllegalArgumentException("参数错误");
//        }
//    }

//    /**
//     * 方法一 暴力算法，双层循环
//     */
//    class Solution {
//        public int[] twoSum(int[] nums, int target) {
//            for (int i = 0; i < nums.length - 1; i++) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[i] == target - nums[j]) {
//                        return new int[]{i, j};
//                    }
//                }
//            }
//            throw new IllegalArgumentException("参数错误");
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}