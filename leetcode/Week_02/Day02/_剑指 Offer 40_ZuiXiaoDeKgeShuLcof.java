//LeetCode题目: 剑指 Offer 40_最小的k个数

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 107 👎 0

package Week_02.Day02;

public class _JZ_Offer_40_ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new _JZ_Offer_40_ZuiXiaoDeKgeShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法五 计数排序
     * 统计每个数字出现的次数，根据counter数组从头找出k个数作为返回结果
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr.length <= k) return arr;
            if (k < 1) return new int[0];
            //统计每个数字出现的次数,前提是数组中的值小于数组长度
            int[] counter = new int[10000];
            for (Integer item : arr) {
                counter[item]++;
            }

            int[] resArr = new int[k];
            int idx = 0;
            for (int i = 0; i < counter.length; i++) {
                while (counter[i]-- > 0 && idx < k) {
                    resArr[idx++] = i;
                }
                if (idx == k) {
                    break;
                }
            }
            return resArr;
        }
    }
//    /**
//     * 方法四 二叉搜索树
//     * 类似于二叉堆，获取树中的最大值进行比较
//     * 时间复杂度：O（NlogK）
//     * 空间复杂度：O（k）
//     */
//    class Solution {
//        public int[] getLeastNumbers(int[] arr, int k) {
//            if (arr.length <= k) return arr;
//            if (k < 1) return new int[0];
//            int[] resArr = new int[k];
//            TreeMap<Integer, Integer> treeMap = new TreeMap();
//            int count = 0; //记录树中的元素个数
//            for (Integer item : arr) {
//                if (count < k) {
//                    treeMap.put(item, treeMap.getOrDefault(item, 0) + 1);
//                    count++;
//                    continue;
//                }
//                //获取map中的最大数字
//                Map.Entry<Integer, Integer> lastEntry = treeMap.lastEntry();
//                if (lastEntry.getKey() > item) {
//                    treeMap.put(item, treeMap.getOrDefault(item, 0) + 1);
//                    if (lastEntry.getValue() == 1) {
//                        treeMap.pollLastEntry();
//                    } else {
//                        treeMap.put(lastEntry.getKey(), lastEntry.getValue() - 1);
//                    }
//                }
//            }
//            int i = 0;
//            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
//                int itemCount = entry.getValue();
//                while (itemCount-- > 0) {
//                    resArr[i++] = entry.getKey();
//                }
//            }
//            return resArr;
//        }
//    }
//    /**
//     * 方法三 快速排序
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public int[] getLeastNumbers(int[] arr, int k) {
//            if (arr.length <= k) return arr;
//            if (k < 1) return new int[0];
//            return quickSearch(arr, 0, arr.length - 1, k - 1); //枢纽下标为k - 1
//        }
//
//        /**
//         * 快排函数
//         *
//         * @param arr
//         * @param lo  最小下标
//         * @param hi  最大下标
//         * @param k   需要快排的第几个元素
//         */
//        private int[] quickSearch(int[] arr, int lo, int hi, int k) {
//            // 每次快排会根据数组第一个元素作为枢纽，将数组拆分为2个子数组，
//            // 且左数组所有元素小于枢纽值，右数组所有元素大于枢纽值
//            // 最后返回枢纽的下标，即该枢纽排序后应该在数组的位置
//            int j = partition(arr, lo, hi);
//            if (j == k) {
//                return Arrays.copyOf(arr, k + 1);
//            }
//            return j < k ? quickSearch(arr, j + 1, hi, k) : quickSearch(arr, lo, j - 1, k);
//        }
//
//        /**
//         * 切分函数，因为求最小元素，所以将lo下标元素作为枢纽，然后将[lo - hi]的元素分别与枢纽比较交换，
//         * 直到ho >= hi，说明枢纽排序后的真实位置就是hi
//         *
//         * @param arr
//         * @param lo
//         * @param hi
//         * @return
//         */
//        private int partition(int[] arr, int lo, int hi) {
//            int pivot = arr[lo];
//            int i = lo, j = hi + 1; //因为lo作为枢纽，所以lo不需要比较，hi就需要比较所以+1,与--j配合
//            while (true) {
//                while (++i <= hi && arr[i] < pivot) ;
//                while (--j >= lo && arr[j] > pivot) ;
//                if (i >= j) break;
//                //交换位置
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//            //最后交换枢纽
//            arr[lo] = arr[j];
//            arr[j] = pivot;
//            return j;
//        }
//    }
//    /**
//     * 方法二 堆
//     * 取最小值用大顶堆，最大值用最小堆
//     * 时间复杂度：O（NlogK）
//     * 空间复杂度：O（k）
//     */
//    class Solution {
//        public int[] getLeastNumbers(int[] arr, int k) {
//            if (arr.length <= k) return arr;
//            if(k < 1) return new int[0];
//            int[] resArr = new int[k];
//            //默认最小堆,这里需要最大堆
//            PriorityQueue<Integer> heap = new PriorityQueue((v1, v2) -> (int) v2 - (int) v1);
//            for (int i = 0; i < arr.length; i++) {
//                if (heap.size() < k) {
//                    heap.add(arr[i]);
//                } else if (arr[i] < heap.peek()) {
//                    heap.poll();
//                    heap.add(arr[i]);
//                }
//            }
//            for (int i = 0; i < k; i++) {
//                resArr[i] = heap.poll();
//            }
//            return resArr;
//        }
//    }
//    /**
//     * 方法一 排序法
//     * 时间复杂度：O（NlogN）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public int[] getLeastNumbers(int[] arr, int k) {
//            if(arr.length <= k) return arr;
//            Arrays.sort(arr);
//            return Arrays.copyOf(arr,k);
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}