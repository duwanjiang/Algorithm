//LeetCode题目: 78_子集

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 675 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
    public static void main(String[] args) {
        Solution solution = new _78_Subsets().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 方法二 递归(回溯算法)
     * 时间复杂度：O（n*2^n）
     * 空间复杂度：O（n*2^n）
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            ArrayList<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            backtrack(0, new ArrayList(), list, nums);
            return list;
        }

        private void backtrack(int i, ArrayList subList, ArrayList<List<Integer>> resList, int[] nums) {
            for (int j = i; j < nums.length; j++) {
                subList.add(nums[j]);
                resList.add(new ArrayList<>(subList));
                backtrack(j + 1, subList, resList, nums);
                subList.remove(subList.size() - 1); //回溯
            }
        }
    }
    /**
     * 方法一 递归(dfs算法)
     * 时间复杂度：O（2^n）
     * 空间复杂度：O（2^n）
     */
//    class Solution {
//        public List<List<Integer>> subsets(int[] nums) {
//            ArrayList<List<Integer>> list = new ArrayList<>();
//            list.add(new ArrayList<>());
//            recurSubSet(0,new ArrayList(),list,nums);
//            return list;
//        }
//
//        //前序遍历
////        private void recurSubSet(int i, ArrayList tempList, ArrayList<List<Integer>> resList, int[] nums) {
////            if(i >= nums.length) return;
////            tempList = new ArrayList(tempList); //生成副本，防止修改上层list对象
////            resList.add(tempList);
////            recurSubSet(i+1,tempList,resList,nums);
////            tempList.add(nums[i]);
////            recurSubSet(i+1,tempList,resList,nums);
////        }
//        //中序遍历
////        private void recurSubSet(int i, ArrayList tempList, ArrayList<List<Integer>> resList, int[] nums) {
////            if(i >= nums.length) return;
////            tempList = new ArrayList(tempList); //生成副本，防止修改上层list对象
////            recurSubSet(i+1,tempList,resList,nums);
////            tempList.add(nums[i]);
////            resList.add(tempList);
////            recurSubSet(i+1,tempList,resList,nums);
////        }
//        //后序遍历
//        private void recurSubSet(int i, ArrayList tempList, ArrayList<List<Integer>> resList, int[] nums) {
//            if(i >= nums.length) return;
//            tempList = new ArrayList(tempList); //生成副本，防止修改上层list对象
//            recurSubSet(i+1,tempList,resList,nums);
//            tempList.add(nums[i]);
//            recurSubSet(i+1,tempList,resList,nums);
//            resList.add(tempList);
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}