package editor.cn.sort;

/**
 * ClassName: InsertionSort. <br/>
 * Description: 归并排序算法. <br/>
 * Date: 2020-12-02 .<br/>
 *
 * @author Wanjiang Du
 * @version 1.0.0
 * @since JDK 1.8
 */
public class MergeSort {

    /**
     * 时间复杂度：N*logN
     * 是否原地排序：否
     * 是否稳定排序：是
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    /**
     * 1、把长度为n的输入序列分成两个长度为n/2的子序列
     * 2、对这两个子序列分别采用归并排序
     * 3、将两个排序好的子序列合并成一个最终的排序序列
     *
     * @param arr
     * @param begin
     * @param end
     */
    private static void mergeSort(int[] arr, int begin, int end) {
        if (end <= begin) return;
        int mid = begin + ((end - begin) >> 1);
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        marge(arr, begin, mid, end);
    }

    /**
     * 合并数组元素
     *
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    private static void marge(int[] arr, int begin, int mid, int end) {
        // 用于重排元素数组
        int[] temp = new int[end - begin + 1];
        int i = begin, j = mid + 1, p = 0;
        // 将2个子数组的元素排序放入temp数组
        while (i <= mid && j <= end) temp[p++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        while (i <= mid) temp[p++] = arr[i++]; // 将mid前子数组剩余元素放入temp数组
        while (j <= end) temp[p++] = arr[j++]; // 将mid后子数组剩余元素放入temp数组

        // 将temp数组拷贝回原数组
        for (int e = 0; e < temp.length; e++) {
            arr[begin + e] = temp[e];
        }
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
