//LeetCode题目: 56_合并区间

//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 574 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _56_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new _56_MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 排序+双指针
     * 时间复杂度：O（logn）
     * 空间复杂度：O（logn）
     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            // 先堆二维数组第一个元素排序
            List<int[]> ints = Arrays.asList(intervals);
            Collections.sort(ints, ((o1, o2) -> o1[0] - o2[0]));
            // 遍历并合并重复区间
            ArrayList<int[]> ansList = new ArrayList<>();
            for (int i = 0; i < ints.size(); ) {
                int t = ints.get(i)[1]; // 记录区间最大值
                int j = i + 1; // 下一个区间
                // 将下一个区间开始值小于等于t的区间进行合并
                while (j < ints.size() && t >= ints.get(j)[0]) {
                    t = Math.max(t, ints.get(j)[1]);
                    j++;
                }
                ansList.add(new int[]{ints.get(i)[0], t}); // 记录合并后数组
                i = j; // 此时j为断开区间数
            }
            // 拷贝ansList --> ans数组
            int[][] ans = new int[ansList.size()][2];
            for (int i = 0; i < ansList.size(); i++) {
                ans[i][0] = ansList.get(i)[0];
                ans[i][1] = ansList.get(i)[1];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}