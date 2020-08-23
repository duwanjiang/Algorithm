//LeetCode题目: 1122_数组的相对排序

//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 77 👎 0

package editor.cn;

public class _1122_RelativeSortArray {
    public static void main(String[] args) {
        Solution solution = new _1122_RelativeSortArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 计数排序
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] count = new int[1001]; //用于计数的数组
            for (int i = 0; i < arr1.length; i++) {
                count[arr1[i]]++; // 记录下标元素出现的次数
            }
            int i = 0;
            // 根据arr2中的元素依次将count中的下标元素放入arr1中
            for (int j = 0; j < arr2.length; j++) {
                int num2 = arr2[j];
                while (count[num2] > 0) {
                    arr1[i++] = num2; // 根据arr2元素进行重排序
                    count[num2]--;
                }
            }
            // 将arr1中剩余元素排序到最后
            for (int j = 0; j < count.length; j++) {
                while (count[j] > 0){
                    arr1[i++] = j; // 将剩余元素放入末尾位置
                    count[j]--;
                }
            }
            return arr1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}