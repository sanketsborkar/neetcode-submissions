/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // Mapping from original node to its cloned counterpart
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        // Base case: if the graph is empty
        if (node == null) {
            return null;
        }

        // If the node has already been cloned, return its clone
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Create a new clone node (isolated copy)
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        // Recursively clone all neighbors and populate the neighbors list
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }

        return newNode;
    }
}