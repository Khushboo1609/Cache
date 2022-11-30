import services.LRUCache;

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);

        cache.printCache();
    }
}