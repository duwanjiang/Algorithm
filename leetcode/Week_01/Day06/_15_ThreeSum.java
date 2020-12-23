//LeetCode题目: 15_三数之和

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2387 👎 0

package Week_01.Day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _15_ThreeSum {
    public static void main(String[] args) {
        Solution solution = new _15_ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法二 2层遍历-双指针夹逼法
     * 时间复杂度：O（n^2）
     * 空间复杂度：O（1）
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length == 0 || nums.length < 3) return Collections.emptyList();
            List<List<Integer>> set = new ArrayList<>();
            //排序
            Arrays.sort(nums);
            for (int k = 0; k < nums.length - 2; k++) {
                if (nums[k] > 0) break; //最小元素不能大于0
                if (k > 0 && nums[k] == nums[k - 1]) continue; //去除重复元素
                int i = k + 1, j = nums.length - 1; //双指针 i < j
                while (i < j) {
                    int sum = nums[k] + nums[i] + nums[j];
                    if (sum < 0) {
                        while (i < j && nums[i] == nums[++i]); //去除重复元素,并右移i
                    } else if (sum > 0) {
                        while (i < j && nums[j] == nums[--j]); //去除重复元素,并左移j
                    } else {
                        set.add(Arrays.asList(nums[k] , nums[i] , nums[j]));
                        while (i < j && nums[i] == nums[++i]); //去除重复元素,并右移i
                        while (i < j && nums[j] == nums[--j]); //去除重复元素,并左移j
                    }
                }
            }
            return new ArrayList<>(set);
        }
    }
//    /**
//     * 方法二 3层遍历
//     * 时间复杂度：O（n^3）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public List<List<Integer>> threeSum(int[] nums) {
//            if (nums.length == 0 || nums.length < 3) return Collections.emptyList();
//            Set<List<Integer>> set = new LinkedHashSet<>();
//            for (int i = 0; i < nums.length - 2; i++) {
//                for (int j = i + 1; j < nums.length - 1; j++) {
//                    for (int k = j + 1; k < nums.length; k++) {
//                        if (nums[i] + nums[j] + nums[k] == 0) {
//                            List list = Arrays.asList(nums[i], nums[j], nums[k]);
//                            list.sort(Comparator.naturalOrder());
//                            set.add(list);
//                        }
//                    }
//                }
//            }
//            return new ArrayList<>(set);
//        }
//    }
//    /**
//     * 方法一 hash + 2层遍历
//     * 时间复杂度：O（n^2）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public List<List<Integer>> threeSum(int[] nums) {
//            if (nums.length == 0 || nums.length < 3) return Collections.emptyList();
//            LinkedHashSet<List<Integer>> set = new LinkedHashSet<>();
//            //a = -c -b;
//            for (int i = 0; i < nums.length - 2; i++) {
//                int target = -nums[i];
//                Map<Integer, Integer> map = new HashMap(nums.length - 1);
//                for (int j = i + 1; j < nums.length; j++) {
//                    int a = target - nums[j];
//                    Integer exist = map.get(a);
//                    if (exist != null) {
//                        List<Integer> tempList = Arrays.asList(-target, nums[j], exist);
//                        tempList.sort(Comparator.naturalOrder());
//                        set.add(tempList);
//                    } else {
//                        map.put(nums[j], nums[j]);
//                    }
//                }
//            }
//            return new ArrayList<>(set);
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}