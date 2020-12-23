package editor.cn.sort;

/**
 * ClassName: InsertionSort. <br/>
 * Description: 堆排序算法. <br/>
 * Date: 2020-12-02 .<br/>
 *
 * @author Wanjiang Du
 * @version 1.0.0
 * @since JDK 1.8
 */
public class HeapSort {

    /**
     * 时间复杂度：N*logN
     * 是否原地排序：是
     * 是否稳定排序：否
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        heapSort(arr);
        printArr(arr);
    }

    /**
     * 1、数组元素依次建立大顶堆
     * 2、逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
     *
     * @param arr
     */
    private static void heapSort(int[] arr) {
        int len = arr.length;
        if (len == 0) return;
        // 现将数组构造为大顶堆
        for (int i = len / 2 - 1; i >= 0; i--) heapify(arr, len, i);
        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i, 0);
        }

    }

    /**
     * 大顶堆调整
     *
     * @param arr
     * @param len
     * @param i
     */
    private static void heapify(int[] arr, int len, int i) {
        // 分别左右子树下标
        int left = 2 * i + 1, rigth = 2 * i + 2, largest = i;
        // 判断左子树是否大于根节点
        if (left < len && arr[left] > arr[largest]) largest = left;
        // 判断右子树是否大于根节点
        if (rigth < len && arr[rigth] > arr[largest]) largest = rigth;
        if (largest != i) {
            // 交换最大值
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            // 继续调整子树顺序
            heapify(arr, len, largest);
        }
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
