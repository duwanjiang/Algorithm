//LeetCode题目: 11_盛最多水的容器

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针 
// 👍 1633 👎 0

package editor.cn;

public class _11_ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new _11_ContainerWithMostWater().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法二 夹逼法-简写
     */
    class Solution {
        public int maxArea(int[] height) {
            int i = 0, j = height.length - 1, maxArea = 0;
            //S(n) = (j - i) * min(height[i],height[j])
            while (i < j) {
                maxArea = height[i] < height[j] ?
                        Math.max(maxArea, height[i] * (j - i++)) :
                        Math.max(maxArea, height[j] * (j-- - i));
            }
            return maxArea;
        }
    }
//    /**
//     * 方法一 夹逼法
//     */
//    class Solution {
//        public int maxArea(int[] height) {
//            int i = 0, j = height.length - 1, maxArea = 0;
//            //S(n) = (j - i) * min(height[i],height[j])
//            int hi = height[i];
//            int hj = height[j];
//            int minHeight = hj;
//            int weight = j - i;
//            while (i < j) {
//                if (hi < hj) {
//                    minHeight = hi;
//                    i++;
//                } else {
//                    j--;
//                }
//                int tempArea = weight * minHeight;
//                if (maxArea < tempArea) {
//                    maxArea = tempArea;
//                }
//            }
//            return maxArea;
//
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}