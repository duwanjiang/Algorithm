//LeetCode题目: 206_反转链表

//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1091 👎 0

package Week_01.Day03;

public class _206_ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new _206_ReverseLinkedList().new Solution();
    }

    /**
     * Definition for singly-linked list.
     **/
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法三 递归-2参数
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            return reverseListRecur(head, null);
        }

        public ListNode reverseListRecur(ListNode head, ListNode newHead) {
            if (head == null) {
                return newHead;
            }
            //调转指向
            head.next = newHead;
            return reverseListRecur(head.next, head);
        }
    }
//    /**
//     * 方法二 递归
//     */
//    class Solution {
//        public ListNode reverseList(ListNode head) {
//            if (head == null || head.next == null) {
//                return head;
//            }
//            ListNode cur = reverseList(head.next);
//            //调转指向
//            head.next.next = head;
//            head.next = null;
//            return cur;
//        }
//    }
//    /**
//     * 方法一 迭代
//     */
//    class Solution {
//        public ListNode reverseList(ListNode head) {
//            //通过pre和cur节点来交换两个节点的next的方向
//            ListNode pre = null;
//            ListNode cur = head;
//            while (cur != null) {
//                //保存一下个节点
//                ListNode nextTemp = cur.next;
//                //交换next节点
//                cur.next = pre;
//                //再将节点切换到下一个节点
//                pre = cur;
//                cur = nextTemp;
//            }
//            return pre;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}