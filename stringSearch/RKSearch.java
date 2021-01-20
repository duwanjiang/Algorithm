import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: BFSearch. <br/>
 * Description: RK Rabin-Karp 字符串匹配算法. <br/>
 * Date: 2021-01-15 .<br/>
 *
 * @author Wanjiang Du
 * @version 2.0.0
 * @since JDK 1.8
 */
public class RKSearch {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "abcdefg";
        int i = rkSearch(str, "ad");
        System.out.println(i);
    }

    /**
     * 暴力搜索算法的升级版，通过一次将主串的每个子串计算hash值，然后模式串的hash值进行比较，当hash值相同时时，
     * 为了避免hash冲突，所以再hash相同的情况下，在进行字符的逐个比较，加快搜索速度
     *
     * @param str
     * @param searchText
     * @return
     */
    private static int rkSearch(String str, String searchText) {
        int len = str.length(), searchLen = searchText.length();
        Map<Integer, Map<String, Integer>> subStrMap = new HashMap<>();
        Integer searchHashCode = searchText.hashCode();
        for (int i = 0; i <= len - searchLen; i++) {
            String subStr = str.substring(i, i + searchLen);
            Map<String, Integer> map = new HashMap<>();
            map.put(subStr, i);
            subStrMap.put(subStr.hashCode(), map);
        }
        Map<String, Integer> map = subStrMap.get(searchHashCode);
        if (map != null) {
            String subStr = map.keySet().iterator().next();
            Integer index = map.values().iterator().next();
            for (int i = 0; i < searchLen; i++) {
                if (subStr.charAt(i) != searchText.charAt(i)) {
                    return -1;
                }
            }
            return index;
        }
        return -1;
    }

}
