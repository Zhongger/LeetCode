package Day42.LRU缓存机制;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,DLinkedNode> map = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.size=0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode dLinkedNode = map.get(key);
        if (dLinkedNode==null){
            return -1;
        }
        moveToHead(dLinkedNode);
        return dLinkedNode.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node==null){
            //如果key不存在
            DLinkedNode dLinkedNode = new DLinkedNode(key, value);
            map.put(key,dLinkedNode);
            addToHead(dLinkedNode);
            size++;
            if (size>capacity){
                DLinkedNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        }else {
            //key存在，先通过哈希表定位，再修改 value，并移到头部
            node.value=value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }

    private void removeNode(DLinkedNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
