package graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph extends Node {
    /**
     * Gives a reference of a node in a connected, undirected graph and returns a deep copy of it.
     * @param node node
     * @return deep copy of the graph
     */
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    /**
     * Performs dfs on our undirected connected graph.
     * @param node node for graph via adj list
     * @param map hashmap to store new node
     * @return new node that was copied
     */
    private Node dfs(Node node, HashMap<Integer, Node> map) {

        if (node == null) {
            return null;        // empty map
        }

        if (map.containsKey(node.val)) {
            return map.get(node.val);   // contains copied node; base case
        } else {    // otherwise, perform DFS on each neighbor of given node
            Node temp = new Node(node.val, new ArrayList<>());
            map.put(temp.val, temp);

            // perform dfs for each neighbor of the given node
            for (Node neighbor: node.neighbors) {
                temp.neighbors.add(dfs(neighbor, map));
            }
            return temp;
        }
    }
}
