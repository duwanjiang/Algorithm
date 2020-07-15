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
// 👍 2377 👎 0

package editor.cn;

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
     * 方法三 双指针夹逼法
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) {
                return Collections.emptyList();
            }
            //双指针法都需要排序
            Arrays.sort(nums);
            List list = new ArrayList();
            //a + b = -c
            for (int k = 0; k < nums.length - 2; k++) {
                if (nums[k] > 0) break; //因为nums[j] > nums[i] > nums[k] > 0 则 a+b+c>0不能得到结果
                if (k > 0 && nums[k] == nums[k - 1]) continue; //去除重复元素，防止得到重复结果
                //i,j指针分别指向k后的一头一尾
                int i = k + 1, j = nums.length - 1;
                while (i < j) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum < 0) {
                        //表示i++，并跳过所有重复的nums[i]；
                        while (i < j && nums[i] == nums[++i]) ;
                    } else if (sum > 0) {
                        //表示j--，并跳过所有重复的nums[j]；
                        while (i < j && nums[j] == nums[--j]) ;
                    } else {
                        //记录组合[k, i, j]至res，执行i += 1和j -= 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合。
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (i < j && nums[i] == nums[++i]) ;
                        while (i < j && nums[j] == nums[--j]) ;
                    }
                }
            }
            return list;
        }
    }

//    /**
//     * 方法二 hash：两重暴力+hash
//     */
//    class Solution {
//        public List<List<Integer>> threeSum(int[] nums) {
//            if (nums == null || nums.length < 3) {
//                return Collections.emptyList();
//            }
//            //因为结果唯一，不能重复，所以使用set集合
//            Set<List<Integer>> set = new LinkedHashSet<>();
//            //a + b = -c
//            for (int i = 0; i < nums.length - 2; i++) {
//                int target = -nums[i]; //-c
//                Map<Integer, Integer> map = new HashMap(nums.length - i);
//                for (int j = i + 1; j < nums.length; j++) {
//                    int v = target - nums[j]; //a = -c - b
//                    Integer exist = map.get(v);
//                    if (exist != null) {
//                        List list = Arrays.asList(nums[i], exist, nums[j]);
//                        //排序结果，用于去重
//                        list.sort(Comparator.naturalOrder());
//                        set.add(list);
//                    } else {
//                        //将nums.length - i个元素放入hash中
//                        //存储b，由于a和b都是以同一个数组，所以，这里的b就相当于a
//                        map.put(nums[j], nums[j]);
//                    }
//                }
//            }
//            return new ArrayList<>(set);
//        }
//    }

//    /**
//     * 方法一 三重循环
//     */
//    class Solution {
//        public List<List<Integer>> threeSum(int[] nums) {
//            if (nums == null || nums.length < 3) {
//                return Collections.emptyList();
//            }
//            //因为结果唯一，不能重复，所以使用set集合
//            Set<List<Integer>> set = new LinkedHashSet<>();
//            //a + b = -c
//            for (int i = 0; i < nums.length - 2; i++) {
//                for (int j = i + 1; j < nums.length - 1; j++) {
//                    for (int k = j + 1; k < nums.length; k++) {
//                        if (nums[i] + nums[j] + nums[k] == 0) {
//                            List list = Arrays.asList(nums[i], nums[j], nums[k]);
//                            //排序结果，用于去重
//                            list.sort(Comparator.naturalOrder());
//                            set.add(list);
//                        }
//                    }
//                }
//            }
//            return new ArrayList<>(set);
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}