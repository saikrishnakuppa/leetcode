import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class GraphExamples {
    // DFS
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return paths;
        }

        dfs(graph, 0, new ArrayList<>(), paths);
        return paths;
    }

    void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        path.add(node);
        if (node == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] nextNodes = graph[node];
        for (int nextNode: nextNodes) {
            dfs(graph, nextNode, path, paths);
            path.remove(path.size() - 1);
        }
    }
    
    public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adjacency_list = new ArrayList<>();        
        for (int i = 0; i < n; i++) {
            adjacency_list.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adjacency_list.get(edge[0]).add(edge[1]);
            adjacency_list.get(edge[1]).add(edge[0]);
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        boolean seen[] = new boolean[n];
        Arrays.fill(seen, false);
        
        while (!stack.isEmpty()) {
            // Get the current node.
            int node = stack.pop();
            
            // Check if we have reached the target node.
            if (node == end) {
                return true;
            }
            
            // Check if we've already visited this node.
            if (seen[node]) {
                continue;
            }
            seen[node] = true;
            
            // Add all neighbors to the stack.
            for (int neighbor : adjacency_list.get(node)) {
                stack.push(neighbor);
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        GraphExamples sol = new GraphExamples();
        int[][] graph = {{4,3,1}, {3,2,4}, {3}, {4}, {}};
        System.out.println(sol.allPathsSourceTarget(graph));
        int[][] nodes = {{0,1}, {1,2}, {2,0}};
        System.out.println(sol.validPath(3, nodes, 0, 2));
        int[][] nodes2 = {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};
        System.out.println(sol.validPath(6, nodes2, 0, 5));

    }
}
