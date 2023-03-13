package SwordForOfferTwo.day10;

import java.util.HashMap;
import java.util.Map;

//剑指 Offer II 031. 最近最少使用缓存
public class LRUCache {

    //双向链表数据结构
    //方法一：哈希表 + 双向链表

    /**
     * LRU 缓存机制可以通过哈希表辅以双向链表实现，我们用一个哈希表和一个双向链表维护所有在缓存中的键值对。
     * 双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的。
     * 哈希表即为普通的哈希映射（HashMap），通过缓存数据的键映射到其在双向链表中的位置。
     * 这样以来，我们首先使用哈希表进行定位，找出缓存项在双向链表中的位置，
     * 随后将其移动到双向链表的头部，即可在 O(1) 的时间内完成 get 或者 put 操作
     *
     * 上述各项操作中，访问哈希表的时间复杂度为 O(1)，在双向链表的头部添加节点、在双向链表的尾部删除节点的复杂度也为 O(1)。
     * 而将一个节点移到双向链表的头部，可以分成「删除该节点」和「在双向链表的头部添加节点」两步操作，都可以在 O(1) 时间内完成。
     * 在双向链表的实现中，使用一个伪头部（dummy head）
     * 和伪尾部（dummy tail）标记界限，这样在添加节点和删除节点的时候就不需要检查相邻的节点是否存在。
     */
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int _key,int _value){this.key = _key;this.value = _value;}
    }

    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();        // 使用伪头部和伪尾部节点
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null) return -1;
        moveToHead(node);        // 如果 key 存在，先通过哈希表定位，再移到头部
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            addToHead(newNode);
            // 添加进哈希表
            cache.put(key,newNode);
            ++size;
            if(size > capacity){
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);                // 删除哈希表中对应的项
                --size;
            }
        }else {
            node.value = value;            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            moveToHead(node);
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
