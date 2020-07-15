//LeetCode题目: 283_移动零

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 649 👎 0

package editor.cn;

public class _283_MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new _283_MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法三：一层循环-变种
     * 有点像快排的思想，着重判断0元素
     */
    class Solution {
        public void moveZeroes(int[] nums) {
            //使用i,j两个指针，i指向非0元素，j指向第一个0元素，遇到非零就swap空间
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    j++;
                } else if (j > 0) {
                    nums[i - j] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
//    /**
//     * 方法二：一层循环
//     * 有点像快排的思想，着重判断非0元素
//     */
//    class Solution {
//        public void moveZeroes(int[] nums) {
//            //使用i,j两个指针，i指向非0元素，j指向第一个0元素，遇到非零就swap空间
//            int j = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] != 0) {
//                    nums[j++] = nums[i];
//                    nums[i] = 0;
//                }
//            }
//        }
//    }

//    /**
//     * 方法一：两层循环
//     * 先记录非零元素，在将0元素赋值到末尾
//     */
//    class Solution {
//        public void moveZeroes(int[] nums) {
//            //先将原数组的非0元素前移
//            int j = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] != 0) {
//                    nums[j++] = nums[i];
//                }
//            }
//
//            //将0元素补入数组尾部
//            for (int i = j; i < nums.length; i++) {
//                nums[i] = 0;
//            }
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}