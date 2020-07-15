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
// 👍 1629 👎 0

package com.cloud._40_algorithm.leetcode.editor.cn;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法三：双指针+Math函数
     * 代码最整洁
     */
//    class Solution {
//        //leetcode submit region begin(Prohibit modification and deletion)
//        public int maxArea(int[] height) {
//            //公式:当i < j , S = min(h(i) , h(j)) * (j - i)
//            int i = 0, j = height.length - 1, maxArea = 0;
//            while (i < j) {
//                maxArea = height[i] < height[j] ?
//                        Math.max(maxArea, (j - i) * height[i++]) :
//                        Math.max(maxArea, (j - i) * height[j--]);
//            }
//            return maxArea;
//        }
//    }

    /**
     * 方法二：双指针+Math函数
     */
//    class Solution {
//        public int maxArea(int[] height) {
//            //公式:当i < j , S = min(h(i) , h(j)) * (j - i)
//            int i = 0, j = height.length - 1, maxArea = 0;
//            while (i < j) {
//                int minHeight = Math.min(height[i], height[j]);
//                maxArea = Math.max(maxArea, minHeight * (j - i));
//                if (height[i] < height[j]) {
//                    i++;
//                } else {
//                    j--;
//                }
//            }
//            return maxArea;
//        }
//    }

    /**
     * 方法一：双指针法
     * 效率最好的
     */
    class Solution {
        public int maxArea(int[] height) {
            //公式:当i < j , S = min(h(i) , h(j)) * (j - i)
            int i = 0, j = height.length - 1, maxArea = 0;
            while (i < j) {
                int hi = height[i], hj = height[j], weight = j - i;
                int minHeight = hj;
                if (hi < hj) {
                    minHeight = hi;
                    i++;
                } else {
                    j--;
                }
                int temp = minHeight * weight;
                if (maxArea < temp) {
                    maxArea = temp;
                }
            }
            return maxArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}