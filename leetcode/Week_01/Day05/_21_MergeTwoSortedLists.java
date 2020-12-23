//LeetCode题目: 21_合并两个有序链表

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1152 👎 0

package Week_01.Day05;

public class _21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new _21_MergeTwoSortedLists().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    /**
     * 方法三 递归-简洁
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //终止条件
            if (l1 == null || l2 == null) return l2 == null ? l1 : l2;
            ListNode smaller = l1.val < l2.val ? l1 : l2;
            smaller.next = mergeTwoLists(smaller.next, smaller == l2 ? l1 : l2);
            return smaller;
        }
    }
//    /**
//     * 方法二 递归
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            //终止条件
//            if (l1 == null) return l2;
//            if (l2 == null) return l1;
//            //判断大小
//            if (l1.val < l2.val) {
//                l1.next = mergeTwoLists(l1.next, l2);
//                return l1;
//            } else {
//                l2.next = mergeTwoLists(l1, l2.next);
//                return l2;
//            }
//        }
//    }
//    /**
//     * 方法一 迭代
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            if (l1 == null) return l2;
//            if (l2 == null) return l1;
//            ListNode newHead = new ListNode(0);
//            ListNode preNode = newHead;
//            while (l1 != null && l2 != null) {
//                //依次比较2个链表的元素大小,小的next -> 大的节点；大的节点指向
//                if (l1.val < l2.val) {
//                    preNode.next = l1;
//                    l1 = l1.next;
//                } else {
//                    preNode.next = l2;
//                    l2 = l2.next;
//                }
//                preNode = preNode.next;
//            }
//            //将最后不为空的节点合并就可以了
//            preNode.next = l1 == null ? l2 : l1;
//            return newHead.next;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}