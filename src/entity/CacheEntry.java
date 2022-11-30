package entity;

import java.util.HashMap;

public class CacheEntry {
    String key ;
    String value;
    private int  hitcount;

    CacheEntry prev,next;

    public CacheEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public void updateHitCount(){
        hitcount++;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public int getHitcount() {
        return hitcount;
    }

    public CacheEntry getPrev() {
        return prev;
    }

    public CacheEntry getNext() {
        return next;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setHitcount(int hitcount) {
        this.hitcount = hitcount;
    }

    public void setPrev(CacheEntry prev) {
        this.prev = prev;
    }

    public void setNext(CacheEntry next) {
        this.next = next;
    }

}
