
class TimeMap {
    // Nested class to combine values and timestamps together
    private static class DataPair {
        String value;
        int timestamp;

        DataPair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    // Map linking each key to its history of pairs
    private Map<String, List<DataPair>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // Compute if absent to initialize array lists lazily
        store.putIfAbsent(key, new ArrayList<>());
        store.get(key).add(new DataPair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        // Return empty if the key has never been added
        if (!store.containsKey(key)) {
            return "";
        }
        
        List<DataPair> history = store.get(key);
        return binarySearch(history, timestamp);
    }

    private String binarySearch(List<DataPair> history, int targetTime) {
        int left = 0;
        int right = history.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (history.get(mid).timestamp <= targetTime) {
                // Potential answer found, look for closer/larger timestamp on the right
                result = history.get(mid).value;
                left = mid + 1;
            } else {
                // Timestamp is too large, narrow down to the left half
                right = mid - 1;
            }
        }
        return result;
    }
}
