/**
 * ClassName: DP. <br/>
 * Description: 动态规划-编辑距离. <br/>
 * Date: 2021-05-13 .<br/>
 *
 * @author Wanjiang Du
 * @version 2.0.0
 * @since JDK 1.8
 */
public class DPEditLength {

    public static void main(String[] args) {
        System.out.println(getEditLength("abcd", "efg"));
        /** 打印结果：
         * \ ' e f g
         * ' 0 1 2 3
         * a 1 1 2 3
         * b 2 2 2 3
         * c 3 3 3 3
         * d 4 4 4 4
         */
    }

    /**
     * 获取2个字符串的编辑距离
     *
     * @param a
     * @param b
     * @return
     */
    private static int getEditLength(String a, String b) {
        int m = a.length(), n = b.length();
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        // 编辑距离矩阵
        int[][] arr = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            arr[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            arr[0][i] = i;
        }
        // 填充编辑矩阵
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 存储aChar与bChar的最小编辑距离
                int r = 1;
                if (aChar[i - 1] == bChar[j - 1]) {
                    r = 0;
                }
                int min = Math.min(arr[i - 1][j], arr[i][j - 1]);
                arr[i][j] = Math.min(min, arr[i - 1][j - 1]) + r;
            }
        }
        print(aChar, bChar, arr, m, n);
        return arr[m][n];
    }

    /**
     * 打印数组
     *
     * @param aChar
     * @param bChar
     * @param arr
     * @param m
     * @param n
     */
    private static void print(char[] aChar, char[] bChar, int[][] arr, int m, int n) {
        System.out.print("\\ ");
        for (int i = -1; i < bChar.length; i++) {
            if (i == -1) {
                System.out.print("' ");
            } else {
                System.out.print(bChar[i] + " ");
            }
        }
        System.out.println("");
        for (int i = 0; i <= m; i++) {
            for (int j = -1; j <= n; j++) {
                if (j == -1 && i == 0) {
                    System.out.print("' ");
                }
                if (j == -1 && i > 0) {
                    System.out.print(aChar[i-1] + " ");
                }
                if(j != -1){
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }
}
