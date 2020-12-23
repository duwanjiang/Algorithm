package editor.cn.sort;

/**
 * ClassName: InsertionSort. <br/>
 * Description: 插入排序算法. <br/>
 * Date: 2020-12-02 .<br/>
 *
 * @author Wanjiang Du
 * @version 1.0.0
 * @since JDK 1.8
 */
public class InsertionSort {

    /**
     * 时间复杂度：N*N
     * 是否原地排序：是
     * 是否稳定排序：是
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        insertionSort(arr);
        printArr(arr);
    }

    /**
     * 从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     *
     * @param arr
     */
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
