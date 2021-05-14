/**
 * ClassName: DP. <br/>
 * Description: 动态规划-金额面值. <br/>
 * Date: 2021-05-13 .<br/>
 *
 * @author Wanjiang Du
 * @version 2.0.0
 * @since JDK 1.8
 */
public class DPCoin {

    public static void main(String[] args) {
        System.out.println(getMinCoinCombo(new int[]{2, 3, 7}, 10));
    }

    /**
     * 获取金币面值组合最小数
     *
     * @param coin
     * @param amount
     * @return
     */
    private static int getMinCoinCombo(int[] coin, int amount) {
        int m = coin.length;
        // 金额最小组合数数组
        int[] arr = new int[amount + 1];
        // 表式初始值，0的金额就是0种组合
        arr[0] = 0;
        int temp = 0;
        for (int i = 1; i <= amount; i++) {
            int minCombo = amount;
            for (int j = 0; j < m; j++) {
                // 金额 - 面额 = 差值
                int diff = i - coin[j];
                if (diff >= 0) {
                    // 状态转移方程
                    temp = arr[diff] + 1;
                } else {
                    temp = amount;
                }
                if (temp < minCombo) {
                    minCombo = temp;
                }
            }
            arr[i] = minCombo;
        }
        print(arr);
        return arr[amount - 1];
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
