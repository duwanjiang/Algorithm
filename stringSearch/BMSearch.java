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
        int i = bmSearch(str, "ad");
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
     * 2.1.2. 情况二 好后缀未能在模式串中找到：我们从好后缀的后缀子串中，找一个最长的并且能跟模式串的前缀子串匹配的，假设是{v}，然后将模式串滑动到2个{v}子串重合的位置。
     * 3. 最后取 坏字符规则与好后缀规则中 移动位数最大值
     *
     * @param str
     * @param searchText
     * @return
     */
    private static int bmSearch(String str, String searchText) {
        int n = str.length(), m = searchText.length();
        // 记录模式串中字符最后出现的位置
        int[] modelCharArr = new int[SIZE];
        // 构建坏字符数组
        generatorBadCharArr(modelCharArr, searchText);
        // 模式串左对齐在主串中的第i个字符
        int i = 0;
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; j--) { // 模式串从后向前匹配
                if (searchText.charAt(j) != str.charAt(i + j)) {
                    break;
                }
            }
            if (j < 0) {
                // 表示字符串匹配成功，并返回主串与模式串匹配的第一个字符下标
                return i;
            }
            // 等同于将模式串往后移动 j - modelCharArr[str[i + j]] 位
            i = i + (j - modelCharArr[(int) str.charAt(i + j)]);
        }
        return -1;
    }

    /**
     * 通过字母ASCII码作为数组下标，数组值存储模式串中字符的下标值
     *
     * @param modelCharArr
     * @param searchText
     * @return
     */
    private static void generatorBadCharArr(int[] modelCharArr, String searchText) {
        // 初始化数组
        for (int i = 0; i < SIZE; i++) {
            modelCharArr[i] = -1;
        }
        for (int i = 0; i < searchText.length(); i++) {
            modelCharArr[(int) searchText.charAt(i)] = i;
        }
    }

}
