package services;

import entity.CacheEntry;

import java.util.HashMap;

public class LRUCache {
    private  HashMap<String, CacheEntry> map;
    private CacheEntry first,last;
    private int size;
    private int CAPACITY_SIZE;
    int hit, miss;

    public LRUCache( int CAPACITY_SIZE) {

        this.CAPACITY_SIZE = CAPACITY_SIZE;
        this.map = new HashMap<>(CAPACITY_SIZE);
    }
    public int size() {
        return size;
    }
    public int getHitCount() {
        return hit;
    }

    public int getMissCount() {
        return miss;
    }

    public void put(String key, String value) {
        CacheEntry node = new CacheEntry(key, value);

        if(map.containsKey(key) == false) {
            if(size() >= CAPACITY_SIZE) {
                deleteNode(first);
            }
            addNodeToLast(node);
        }
        map.put(key, node);
    }


    public String get(String key) {
        if(map.containsKey(key) == false) {
            return null;
        }
        CacheEntry node = (CacheEntry) map.get(key);
        node.updateHitCount();
        reorder(node);
        return (String) node.getValue();

    }


    public void deleteNode(String key) {
        deleteNode(map.get(key));
    }


    private void deleteNode(CacheEntry node) {
        if(node == null) {
            return;
        }
        if(last == node) {
            last = node.getPrev();
        }
        if(first == node) {
            first = node.getNext();
        }
        map.remove(node.getKey());
        node = null; // Optional, collected by GC
        size--;
    }

    private void addNodeToLast(CacheEntry node) {
        if(last != null) {
            last.setNext(node);
            node.setPrev(last);
        }

        last = node;
        if(first == null) {
            first = node;
        }
        size++;
    }

    private void reorder(CacheEntry node) {
        if(last == node) {
            return;
        }
        if(first == node) {
            first = node.getNext();
        } else {
            node.getPrev().setNext(node.getNext());
        }
        last.setNext(node);
        node.setPrev(last);
        node.setNext(null);
        last = node;
    }

    public void printCache(){
        System.out.println(this.map);
    }




}
