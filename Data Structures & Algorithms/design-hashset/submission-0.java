class MyHashSet {

    List<Integer> setData;

    public MyHashSet() {
        setData = new ArrayList<>();
    }
    
    public void add(int key) {
        if (!setData.contains(key)) 
            setData.add(key);
    }
    
    public void remove(int key) {
        setData.remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        return setData.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */