//LeetCode题目: 322_零钱兑换

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划 
// 👍 737 👎 0

package Week_04.Day06;

import java.util.Arrays;

public class _322_CoinChange {
    public static void main(String[] args) {
        Solution solution = new _322_CoinChange().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 DP动态规划
     * 时间复杂度：O（S^n） S-总金额
     * 空间复杂度：O（n）
     */
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1; //最大步数不可能超过最大金额数
            int[] dp = new int[amount + 1]; //记录每种金额的最小步数
            Arrays.fill(dp, max); //将最大值填充数组
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) { //总金额
                for (int j = 0; j < coins.length; j++) { //遍历每个硬币
                    if (coins[j] <= i) { //只有在面值小于总金额时才可以计算次数
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); //上一个面值的步数+1
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}