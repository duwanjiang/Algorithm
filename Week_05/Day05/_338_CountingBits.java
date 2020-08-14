//LeetCode题目: 338_比特位计数

//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划 
// 👍 381 👎 0

package editor.cn;

public class _338_CountingBits {
    public static void main(String[] args) {
        Solution solution = new _338_CountingBits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法三 动态规划+最低有效位
     * P(x)=P(x/2)+(x mod 2)
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public int[] countBits(int num) {
            int[] arr = new int[num + 1];
            for (int i = 1; i <= num; i++) {
                arr[i] = arr[i >> 1] + (i & 1); //P(x)=P(x/2)+(x mod 2)
            }
            return arr;
        }
    }
//    /**
//     * 方法二 动态规划+最后设置位
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public int[] countBits(int num) {
//            int[] arr = new int[num + 1];
//            for (int i = 1; i <= num; i++) {
//                arr[i] = arr[i & (i - 1)] + 1;
//            }
//            return arr;
//        }
//    }
//    /**
//     * 方法一 迭代+位运算
//     * 时间复杂度：O（nk）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public int[] countBits(int num) {
//            int[] arr = new int[num + 1];
//            for (int i = 0; i <= num; i++) {
//                int temp = i;
//                while (temp != 0) {
//                    arr[i]++;
//                    temp &= temp - 1;
//                }
//            }
//            return arr;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}