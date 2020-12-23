package editor.cn.sort;

/**
 * ClassName: InsertionSort. <br/>
 * Description: 选择排序算法. <br/>
 * Date: 2020-12-02 .<br/>
 *
 * @author Wanjiang Du
 * @version 1.0.0
 * @since JDK 1.8
 */
public class SelectionSort {

    /**
     * 时间复杂度：N*N
     * 是否原地排序：是
     * 是否稳定排序：是
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        selectionSort(arr);
        printArr(arr);
    }

    /**
     * 每次找最小值，然后放到待排序数组的起始位置。
     *
     * @param arr
     */
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            // 交换最小元素
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
