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
// 👍 1092 👎 0

package editor.cn;

public class _206_ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new _206_ReverseLinkedList().new Solution();
    }

    //     Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法四：魔幻化双指针
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode cur = head;
            while (head.next != null){
                ListNode tempNode = head.next.next;
                head.next.next = cur;
                cur = head.next;
                head.next = tempNode;
            }

            return cur;
        }

    }
//    /**
//     * 方法三：递归-增加前节点
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public ListNode reverseList(ListNode head) {
//            return reverseListRecur(head, null);
//        }
//
//        public ListNode reverseListRecur(ListNode head, ListNode preNode) {
//            if (head == null) {
//                return preNode;
//            }
//            //调转指向
//            ListNode nextNode = head.next;
//            head.next = preNode;
//            return reverseListRecur(nextNode, head);
//        }
//    }
//    /**
//     * 方法二：迭代方法
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（1）
//     */
//    class Solution {
//        public ListNode reverseList(ListNode head) {
//            if (head == null || head.next == null) {
//                return head;
//            }
//            //通过2个指针来调换相邻2个节点的指向
//            ListNode pre = null;
//            ListNode cur = head;
//            while (cur!=null){
//                ListNode nextNode = cur.next;
//                cur.next = pre;
//                pre = cur;
//                cur = nextNode;
//            }
//            return pre;
//        }
//    }

    /**
     * 方法一：递归方法
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     */
//    class Solution {
//        public ListNode reverseList(ListNode head) {
//            //terminator
//            if (head == null || head.next == null) {
//                return head;
//            }
//            //drill down
//            ListNode nextNode = reverseList(head.next);
//            //process
//            head.next.next = head;
//            head.next = null;
//            //restore current status
//            return nextNode;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}