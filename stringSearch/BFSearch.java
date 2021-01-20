/**
 * ClassName: BFSearch. <br/>
 * Description: BF 暴力字符串匹配算法. <br/>
 * Date: 2021-01-15 .<br/>
 *
 * @author Wanjiang Du
 * @version 2.0.0
 * @since JDK 1.8
 */
public class BFSearch {

    /**
     * 时间复杂度：O(mn)
     * 空间复杂度：O(n)
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "abcdefg";
        int i = bfSearch(str, "efg");
        System.out.println(i);
    }

    /**
     * 暴力搜索算法，就是通过逐个比较搜索字符串的每个字符来判断是否存在相同字符串
     *
     * @param str
     * @param searchText
     * @return
     */
    private static int bfSearch(String str, String searchText) {
        int len = str.length(), searchLen = searchText.length();
        for (int i = 0; i <= len - searchLen; i++) {
            for (int j = 0; j < searchLen; j++) {
                if (str.charAt(i + j) != searchText.charAt(j)) {
                    break;
                }
                if (j == searchLen - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
