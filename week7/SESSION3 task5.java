import java.util.LinkedList;

class MyHashSet {
    private static final int BASE = 769; // A prime number to minimize collisions
    private LinkedList<Integer>[] set;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        set = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            set[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % BASE;
    }

    public void add(int key) {
        int index = hash(key);
        if (!set[index].contains(key)) {
            set[index].add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        set[index].remove((Integer) key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        return set[index].contains(key);
    }
}
