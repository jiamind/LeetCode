import java.util.Arrays;

/**
 * Created by udingji on 5/17/17.
 */
public class GraphValidTree {

    // Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

    // For example:
    // Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
    // Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

    // Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.


    // Idea: union find algorithm.
    // The edge should not connect two nodes which belong to the same set (e.g. already connected directly or indirectly)
    public boolean validTree(int n, int[][] edges) {

        int[] subsets = new int[n];
        Arrays.fill(subsets,-1);

        for (int i = 0; i < edges.length; i++){
            int xSubset = find(subsets,edges[i][0]);
            int ySubset = find(subsets,edges[i][1]);

            if (xSubset == ySubset)
                return false;

            subsets[xSubset] = ySubset;

        }

        return edges.length == n - 1;
    }

    private int find(int[] subsets, int num){
        if (subsets[num] == -1)
            return num;
        return find(subsets,subsets[num]);
    }
}
