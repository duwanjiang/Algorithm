//LeetCode题目: 347_前 K 个高频元素

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 403 👎 0

package editor.cn;

import java.util.HashMap;
import java.util.PriorityQueue;

public class _347_TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new _347_TopKFrequentElements().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 堆
     * 时间复杂度：O（NlogK）
     * 空间复杂度：O（n）
     */
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if (nums.length == 0 || k == 0) return new int[0];
            if (nums.length == 1 && k == 1) return nums;
            //用小顶堆
            HashMap<Integer, Integer> map = new HashMap<>();
            //根据出现次数排序
            PriorityQueue<Integer> heap = new PriorityQueue<>((v1, v2) -> map.get(v1) - map.get(v2));
            for (Integer num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Integer key : map.keySet()) {
                heap.add(key);
                if (heap.size() > k) heap.poll(); //O(1)移除最小值
            }
            int[] output = new int[k];
            for (int i = k - 1; i >= 0; i--) {
                output[i] = heap.poll();
            }
            return output;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}