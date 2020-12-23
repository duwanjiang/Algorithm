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
// 👍 770 👎 0

package Week_02.Day07;

import java.util.HashMap;
import java.util.Map;

public class _146_LruCache {
    public static void main(String[] args) {
        _146_LruCache lruCache = new _146_LruCache();
        LRUCache cache = lruCache.new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);    // 该操作会使得关键字 2 作废
        cache.put(4, 1);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));       // 返回  -1
        System.out.println(cache.get(2));       // 返回  4

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法一 hash+队列
     * 时间复杂度：O（1）
     * 空间复杂度：O（n）
     */
    class LRUCache {

        int capacity = 0;
        int size = 0;
        Map<Integer, Node> map;
        Node head;
        Node tail;

        private class Node {
            Integer key;
            Integer value;
            public Node pre, next;

            public Node(Integer key, Integer value) {
                this.key = key;
                this.value = value;
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            head = new Node(null, null);
            tail = new Node(null, null);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            } else {
                //移动节点到head去
                moveToHeap(node);
                return node.value;
            }
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                moveToHeap(node); //移动节点到head去
            } else {
                //在队首添加节点
                node = new Node(key, value);
                map.put(key, node);
                addHead(node);
                //当元素大于等于容量时，需要移除队尾原数，即最近最少使用元素
                if (++size > capacity) {
                    remodeTail();
                    size--;
                }
            }
        }

        private void moveToHeap(Node node) {
            removeNode(node);
            addHead(node);
        }

        private void addHead(Node node) {
            head.next.pre = node;
            node.pre = head;
            node.next = head.next;
            head.next = node;
        }

        private void removeNode(Node node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }

        private void remodeTail() {
            //移除hash
            map.remove(tail.pre.key);
            removeNode(tail.pre);
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