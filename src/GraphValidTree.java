import java.util.Arrays;

/**
 * Created by udingji on 5/17/17.
 */
public class GraphValidTree {

    // Idea: union find algorithm
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
