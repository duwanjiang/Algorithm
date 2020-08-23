//LeetCode题目: 146_LRU缓存机制

//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 823 👎 0

package editor.cn;

import java.util.HashMap;

public class _146_LruCache {
    public static void main(String[] args) {
        LRUCache solution = new _146_LruCache().new LRUCache();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 hash+双向队列
     * 时间复杂度：O（1）
     * 空间复杂度：O（n）
     */
    class LRUCache {

        Node head;
        Node tail;
        int capacity;
        int size;
        HashMap<Integer, Node> map;

        class Node {
            int key;
            int value;
            Node preNode;
            Node nextNode;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.map = new HashMap(capacity);
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            tail.preNode = head;
            head.nextNode = tail;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            } else {
                moveToHead(node);
                return node.value;
            }
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null) {
                Node temp = new Node(key, value);
                map.put(key, temp);
                addHead(temp);
                if (++size > capacity) { //当集合大小大于容量时移除队尾节点
                    removeTail();
                }
            } else {
                node.value = value;
                moveToHead(node); //移动节点到head去
            }
        }

        private void removeNode(Node node) {
            node.preNode.nextNode = node.nextNode;
            node.nextNode.preNode = node.preNode;
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addHead(node);
        }

        private void addHead(Node node) {
            head.nextNode.preNode = node;
            node.nextNode = head.nextNode;
            head.nextNode = node;
            node.preNode = head;
        }

        private void removeTail() {
            //移除hash值
            map.remove(tail.preNode.key);
            removeNode(tail.preNode);
            size--;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}