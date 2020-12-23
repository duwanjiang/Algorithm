//LeetCode题目: 24_两两交换链表中的节点

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 548 👎 0

package Week_01.Day04;

public class _24_SwapNodesInPairs {
    public static void main(String[] args) {
        _24_SwapNodesInPairs swapNodesInPairs = new _24_SwapNodesInPairs();
        Solution solution = swapNodesInPairs.new Solution();
        ListNode node = swapNodesInPairs.generate();
        swapNodesInPairs.print(node);
        node = solution.swapPairs(node);
        swapNodesInPairs.print(node);

    }

    private void print(ListNode node) {
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println("]");
    }

    private ListNode generate() {
        ListNode listNode = new ListNode(1);
        ListNode temp = listNode;
        for (int i = 0; i < 7; i++) {
            temp.next = new ListNode(i + 2);
            temp = temp.next;
        }
        return listNode;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法二 迭代
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            //用于存储头节点
            ListNode dump = new ListNode(0);
            dump.next = head;
            ListNode preNode = dump;
            //终止条件
            while (head != null && head.next != null) {
                ListNode firstNode = head;
                ListNode secondNode = head.next;

                //开始交换节点
                preNode.next = secondNode;  //preNode指向前驱节点
                firstNode.next = secondNode.next;
                secondNode.next = firstNode;

                //初始化head和preNode节点
                preNode = firstNode;
                head = firstNode.next; //jump
            }
            return dump.next;
        }

    }
//    /**
//     * 方法一 递归
//     * 时间复杂度：O（n）
//     * 空间复杂度：O（n）
//     */
//    class Solution {
//        public ListNode swapPairs(ListNode head) {
//            return swapPairsRecur(head);
//        }
//
//        private ListNode swapPairsRecur(ListNode head) {
//            //终止条件
//            if (head == null || head.next == null) {
//                return head;
//            }
//            //swap的处理顺序永远是依次处理=右边的变量
//            //每次处理2个节点,所以这里要缓存一个节点,且进行反转
//            ListNode nextNode = head.next;
//            //子函数返回head.next.next节点
//            head.next = swapPairsRecur(nextNode.next);
//            //让第二个节点指向第一个节点
//            nextNode.next = head;
//
//            //返回子链表
//            return nextNode;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}