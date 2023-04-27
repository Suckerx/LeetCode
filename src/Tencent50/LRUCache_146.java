package Tencent50;

import java.util.HashMap;
import java.util.Map;

//146. LRU 缓存
public class LRUCache_146 {

    //https://leetcode.cn/problems/lru-cache/solutions/259678/lruhuan-cun-ji-zhi-by-leetcode-solution/?orderBy=hot

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(){}
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private Node head,tail;
    private Map<Integer,Node> cache = new HashMap<>();

    public LRUCache_146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) return -1;
        moveTohead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node == null){
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            addTohead(newNode);
            ++size;
            if(size > capacity){
                Node tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            node.value = value;
            moveTohead(node);
        }
    }

    private void addTohead(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveTohead(Node node){
        removeNode(node);
        addTohead(node);
    }

    private Node removeTail(){
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

}
