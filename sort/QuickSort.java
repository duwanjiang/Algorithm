package editor.cn.sort;

/**
 * ClassName: InsertionSort. <br/>
 * Description: 快速排序算法. <br/>
 * Date: 2020-12-02 .<br/>
 *
 * @author Wanjiang Du
 * @version 1.0.0
 * @since JDK 1.8
 */
public class QuickSort {

    /**
     * 时间复杂度：N*logN
     * 是否原地排序：是
     * 是否稳定排序：是
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    /**
     * 数组取标杆pivot，将小元素放在pivot左边，大元素放右侧，然后依次对左边和右边的子数组继续快排；以达到整个序列有序。
     *
     * @param arr
     * @param begin
     * @param end
     */
    private static void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    /**
     * 获取标杆位置，并将小于pivot的元素放入pivot左侧，大于则放入右侧
     *
     * @param arr
     * @param begin
     * @param end
     * @return
     */
    private static int partition(int[] arr, int begin, int end) {
        int pivot = end, count = begin;
        for (int i = begin; i < end; i++) {
            // 小于标杆则替换到pivot左侧
            if (arr[i] < arr[pivot]) {
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;
                count++;
            }
        }
        // 将pivot放置到数组排序后该到的位置
        int temp = arr[pivot];
        arr[pivot] = arr[count];
        arr[count] = temp;
        return count;
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
