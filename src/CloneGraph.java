import java.util.*;

/**
 * Created by jmding on 4/24/17.
 */
public class CloneGraph {

    // Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

    // OJ's undirected graph serialization:
    // Nodes are labeled uniquely.

    // We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
    // As an example, consider the serialized graph {0,1,2#1,2#2,2}.

    // The graph has a total of three nodes, and therefore contains three parts as separated by #.

    // First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    // Second node is labeled as 1. Connect node 1 to node 2.
    // Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.

    // Visually, the graph looks like the following:
    //        1
    //       / \
    //      /   \
    //     0 --- 2
    //          / \
    //          \_/

    private class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    // Idea: Traverse the graph. Create new node for each existing node and link the neighbors
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        // If the node is null, return null
        if (node == null)
            return null;

        // Create a hashmap to store new copies of node
        HashMap<Integer,UndirectedGraphNode> graphNodeHashMap = new HashMap<>();

        // Make a copy of the node (root) and put it in the hashmap
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        graphNodeHashMap.put(node.label,result);

        // Create a queue to store unvisited node
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        // Add the node (root) to the queue
        queue.offer(node);

        // While there is unvisited node
        while (queue.size() > 0){

            // Poll the node from the queue
            UndirectedGraphNode ugn = queue.poll();

            // For each neighbor of the node
            for (UndirectedGraphNode neighbor : ugn.neighbors) {
                // If we have not create a copy of the node
                if (!graphNodeHashMap.containsKey(neighbor.label)) {
                    // Create a copy of the node
                    UndirectedGraphNode temp = new UndirectedGraphNode(neighbor.label);
                    //Put this new copy into the hashmap
                    graphNodeHashMap.put(neighbor.label, temp);
                    // Add this neighbor to the queue
                    queue.offer(neighbor);
                }
                // Link this copy of neighbor to the copy of the parent node
                graphNodeHashMap.get(ugn.label).neighbors.add(graphNodeHashMap.get(neighbor.label));
            }
        }

        // Return the result
        return result;
    }

}
