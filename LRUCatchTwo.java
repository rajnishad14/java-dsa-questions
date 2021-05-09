// In this Implimnentation i have used doubly linked list for tracking

import java.util.*;
class LRUCacheTwo {
    Map<Integer, Node> map;
    Node head = new Node(), tail = new Node();
    int capacity;
    public LRUCacheTwo(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){
            if(capacity == map.size()){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            node = new Node(key, value);
            map.put(key, node);
            add(node);
        }else{
            node.val = value;
            remove(node);
            add(node);
        }
    }
    
    public void remove(Node node){
        Node nodeNext = node.next;
        Node nodePrev = node.prev;
        nodeNext.prev = nodePrev;
        nodePrev.next = nodeNext;
    }
    public void add(Node node){
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(){};
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}