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
// 👍 571 👎 0

package Week_06.Day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new _56_MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 排序+双指针
     * 时间复杂度：O（nlogn）
     * 空间复杂度：O（nlogn）
     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> ints = Arrays.asList(intervals);
            ArrayList<int[]> newInter = new ArrayList<>(ints);
            newInter.sort((o1, o2) -> o1[0] - o2[0]);
            ArrayList<int[]> res = new ArrayList<>();
            for (int i = 0; i < newInter.size(); ) {
                int t = newInter.get(i)[1];
                int j = i + 1;
                while (j < newInter.size() && newInter.get(j)[0] <= t) {
                    t = Math.max(t, newInter.get(j)[1]);
                    j++;
                }
                res.add(new int[]{newInter.get(i)[0], t});
                i = j;
            }
            int[][] ans = new int[res.size()][2];
            for (int i = 0; i < res.size(); i++) {
                ans[i][0] = res.get(i)[0];
                ans[i][1] = res.get(i)[1];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}