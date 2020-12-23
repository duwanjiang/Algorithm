package editor.cn.sort;

/**
 * ClassName: BubbleSort. <br/>
 * Description: 冒泡排序算法. <br/>
 * Date: 2020-12-02 .<br/>
 *
 * @author Wanjiang Du
 * @version 1.0.0
 * @since JDK 1.8
 */
public class BubbleSort {

    /**
     * 时间复杂度：N*N
     * 是否原地排序：是
     * 是否稳定排序：是
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        bubbleSort(arr);
        printArr(arr);
    }

    /**
     * 嵌套循环，每次查看相邻的元素，如果逆序，则交换。
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
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
