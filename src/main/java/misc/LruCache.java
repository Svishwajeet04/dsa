package misc;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

    final int size;
    final Node head;
    final Node last;

    private final Map<Integer, Node> map = new HashMap<>();

    public LruCache(int size) {
        this.size = size;
        this.head = new Node();
        this.last = new Node();
        head.next = last;
        last.prev = head;
    }

    public int get(int key) {
        if(map.get(key) != null){
            Node node =  map.get(key);
            deleteNode(node);
            insertNode(key, node.val);
            return node.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int val) {
        if(map.get(key) != null){
            deleteNode(map.get(key));
            insertNode(key, val);
        }else{
            if(size == map.size()){
                deleteNode(last.prev);
            }
            insertNode(key, val);
        }
    }

    private void insertNode(int key, int val) {
        Node node = new Node();
        node.key = key;
        node.val = val;
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        map.put(key, node);
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }


    private static class Node {
        int val;
        int key;
        Node prev;
        Node next;
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(3);
        System.out.println(lruCache.get(3));
        lruCache.put(3, 4);
        lruCache.put(5, 4);
        lruCache.put(6, 4);
        lruCache.put(7, 4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
    }
}
