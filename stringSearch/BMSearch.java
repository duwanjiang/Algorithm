/**
 * ClassName: BFSearch. <br/>
 * Description: RK Boyer-Moore 字符串匹配算法. <br/>
 * Date: 2021-01-15 .<br/>
 *
 * @author Wanjiang Du
 * @version 2.0.0
 * @since JDK 1.8
 */
public class BMSearch {

    private static final int SIZE = 256;

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "abcdefg";
        int i = bmSearch(str, "de");
        System.out.println(i);
    }

    /**
     * BM 算法包含两部分，分别是坏字符规则（bad character rule）和好后缀规则（good suffix shift）
     * 1. 坏字符规则:
     * 我们从模式串的末尾往前倒着匹配，当我们发现某个字符没法匹配的时候。我们把这个没有匹配的字符叫作坏字符（主串中的字符）
     * 1.1. 坏字符移动规则：当发生不匹配的时候，我们把坏字符对应的模式串中的字符下标记作 si。如果坏字符在模式串中存在，我们把这个坏字符在模式串中最靠后的下标记作 xi。如果不存在，我们把 xi 记作 -1。那模式串往后移动的位数就等于 si-xi。（注意，我这里说的下标，都是字符在模式串的下标）。
     * <p>
     * 2. 好后缀规则：
     * 如下所示，从右到左匹配，bc为好后缀，
     * 主 串: a b c a c a b c b c b a c a b c
     * 模式串:      a b b c a b c
     * 2.1. 好后缀滑动规则：
     * 2.1.1. 情况一 好后缀能在模式串中找到：如上，bc为好后缀，记作{u}。我们拿它在模式串中查找，如果找到了另一个跟{u}相匹配的子串{u*}，那我们就将模式串滑动到子串{u*}与主串中{u}对齐的位置。
     * 2.1.2. 情况二 好后缀未能在模式串中找到：我们从好后缀的后缀子串中，找一个最长的并且能跟模式串的前缀子串匹配的，假设是{v}，然后将模式串滑动到让{v}子串与主串的{v}重合的位置。
     * 3. 最后取 坏字符规则与好后缀规则中 移动位数最大值
     *
     * @param str
     * @param modelStr
     * @return
     */
    private static int bmSearch(String str, String modelStr) {
        int n = str.length(), m = modelStr.length();
        // 记录模式串中字符最后出现的位置
        int[] modelCharArr = new int[SIZE];
        // 构建坏字符数组
        generateBadCharArr(modelCharArr, modelStr);
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(modelStr, m, suffix, prefix);
        // 模式串左对齐在主串中的第i个字符
        int i = 0;
        while (i <= n - m) {
            int j; // j表示坏字符对应的模式串中的字符下标
            for (j = m - 1; j >= 0; j--) { // 模式串从后向前匹配
                if (modelStr.charAt(j) != str.charAt(i + j)) {
                    break;
                }
            }
            if (j < 0) {
                // 表示字符串匹配成功，并返回主串与模式串匹配的第一个字符下标
                return i;
            }
            // 等同于将模式串往后移动 j - modelCharArr[str[i + j]] 位
            int x = j - modelCharArr[(int) str.charAt(i + j)];
            int y = 0;
            if (j < m - 1) { // 如果有好后缀的话
                y = moveByGS(j, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    /**
     * 好后缀移动位数
     * j表示坏字符对应的模式串中的字符下标; m表示模式串长度
     *
     * @param j
     * @param m
     * @param suffix
     * @param prefix
     * @return
     */
    private static int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j; // 好后缀长度
        // 表示存在好后缀的另一个匹配的字符
        if (suffix[k] != -1) {
            return j - suffix[k] + 1; // 让主串的好后缀与模式串的另一个匹配好后缀对齐
        }
        // 判断好后缀的后缀子串与模式串的前缀子串是否匹配,后缀子串长度 < k ，所以需要判断子串长度从 k-1 到 1 进行判断
        // k = m - 1 - j;
        // ==> k = m - j - 1 = m - r + 1
        // ==> r = j + 2
        for (int r = j + 2; r <= m - 1; r++) {
            if (prefix[m - r] == true) {
                return r;
            }
        }
        // 如果都没有匹配的则直接移动整个模式串长度
        return m;
    }

    /**
     * 通过字母ASCII码作为数组下标，数组值存储模式串中字符的下标值
     *
     * @param modelCharArr
     * @param searchText
     * @return
     */
    private static void generateBadCharArr(int[] modelCharArr, String searchText) {
        // 初始化数组
        for (int i = 0; i < SIZE; i++) {
            modelCharArr[i] = -1;
        }
        for (int i = 0; i < searchText.length(); i++) {
            modelCharArr[(int) searchText.charAt(i)] = i;
        }
    }

    /**
     * 好字符生成算法
     * 1、情况一：好后缀也是模式串的后缀子串，所以好后缀在模式串中查找，为了计算方便，我们先初始化好后缀数组suffix[i]，其中数组的下标i是好后缀的长度，
     * 对应的值为好后缀在模式串中另一个匹配字符的首字母在模式串中的下标位置
     * 示例：
     * 模式串:
     * c a b c a b
     * 0 1 2 3 4 5
     * suffix[1] = 2，因为b在模式串中的另一个配置字符的首字符的下标位置为2
     * suffix[2] = 1，因为ab在模式串中的另一个匹配字符的首字符的下标位置为1
     * suffix[3] = 0，因为cab在模式串中的另一个匹配字符的首字符的下标位置为0
     * suffix[4] = -1，因为bcab在模式串中的未找到另一个匹配字符，所以为-1
     * suffix[5] = -1，因为abcab在模式串中的未找到另一个匹配字符，所以为-1
     * <p>
     * 2、情况二：使用prefix[i]记录好后缀字符串是否有与之匹配的模式串的前缀子串
     * 示例：
     * 模式串:
     * c a b c a b
     * 0 1 2 3 4 5
     * prefix[1] = false，因为b好后缀子串和c模式串前缀子串不匹配
     * prefix[2] = false，因为ab好后缀子串和ca模式串前缀子串不匹配
     * prefix[3] = true，因为cab好后缀子串和cab模式串前缀子串匹配
     * prefix[4] = false，因为bcab好后缀子串和cabc模式串前缀子串不匹配
     * prefix[5] = false，因为abcab好后缀子串和cabca模式串前缀子串不匹配
     * <p>
     * 3、如果公共后缀子串的长度是 k，那我们就记录 suffix[k]=j（j 表示公共后缀子串的起始下标）。如果 j 等于 0，也就是说，公共后缀子串也是模式串的前缀子串，我们就记录 prefix[k]=true
     *
     * @param modelStr
     * @param m
     * @param suffix
     * @param prefix
     */
    private static void generateGS(String modelStr, int m, int[] suffix, boolean[] prefix) {
        // 初始化数组
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        // 遍历模式串
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            // 公共后缀子串长度
            int k = 0;
            // 求模式串公共后缀子串长度
            while (j >= 0 && modelStr.charAt(j) == modelStr.charAt(m - 1 - k)) {
                j--;
                k++;
                suffix[k] = j + 1;
            }
            // 如果公共后缀子串也是模式串的前缀子串
            if (j == -1) prefix[k] = true;
        }
    }

}
