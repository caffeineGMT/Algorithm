import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
    private class Node {
        private String label;

        private Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();
        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();
        // directed graph
        adjacencyList.get(fromNode).add(toNode);
        // non-directed graph
        // adjacencyList.get(fromNode).add(toNode);
        // adjacencyList.get(toNode).add(fromNode);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();
        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if (node == null)
            return;
        for (var i : adjacencyList.keySet()) {
            adjacencyList.get(i).remove(node);
        }
        adjacencyList.remove(node);
        nodes.remove(node.label);
    }

    public void traverseDepthFirstRec(String root, Set<String> visitedNodeSet) {
        var node = nodes.get(root);
        if (node == null)
            return;
        // process the shout-out step in iteration, instead of checking block
        System.out.println(node.label);
        visitedNodeSet.add(node.label);

        var list = adjacencyList.get(node);
        if (list.isEmpty())
            return;

        for (var item : adjacencyList.get(node))
            if (!visitedNodeSet.contains(node.label))
                // process the shout-out step in iteration, instead of checking block
                traverseDepthFirstRec(item.label, visitedNodeSet);
    }

    public void traverseDepthFirstRec(String root) {
        Set<String> visitedNodeSet = new HashSet<>();
        // if we want to traverse all nodes in directed graph
        for (var key : nodes.keySet())
            traverseDepthFirstRec(key, visitedNodeSet);
        // if we want to just traverse from the start node in directed graph
        // traverseDepthFirstRec(key, visitedNodeSet);
    }

    public void traverseDepthFirstIter(String start) {
        var root = nodes.get(start);
        if (root == null)
            return;

        var stack = new Stack<Node>();
        stack.push(root);
        Set<Node> visited = new HashSet<>();

        while (!stack.isEmpty()) {
            // process the shout-out step in iteration, instead of checking block
            var cur = stack.pop();

            // it is possible that other nodes already visited some nodes before, and these
            // visited nodes haven't popped out from the stack
            if (visited.contains(cur))
                continue;

            System.out.println(cur);
            visited.add(cur);

            for (var neighbor : adjacencyList.get(cur))
                if (!visited.contains(neighbor))
                    stack.push(neighbor);
        }
    }

    public void traverseBreathFirstIter(String start) {
        var root = nodes.get(start);
        if (root == null)
            return;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Set<Node> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            var cur = queue.remove();

            // it is possible that other nodes already visited some nodes before, and these
            // visited nodes haven't popped out from the queue
            if (visited.contains(cur))
                continue;

            System.err.println(cur.label);
            visited.add(cur);

            for (var node : adjacencyList.get(cur)) {
                if (!visited.contains(node))
                    queue.add(node);
            }
        }
    }

    private void topologicalSort(Node start, Set<Node> visited, Stack<Node> stack) {
        if (start == null)
            return;

        if (visited.contains(start))
            return;

        visited.add(start);

        for (var neighbor : adjacencyList.get(start))
            if (!visited.contains(neighbor))
                topologicalSort(neighbor, visited, stack);

        stack.push(start);
    }

    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        for (var node : nodes.values()) {
            topologicalSort(node, visited, stack);
            System.out.println("iteration");
        }

        List<String> list = new ArrayList<>();
        while (!stack.isEmpty())
            list.add(stack.pop().label);

        return list;
    }

    public boolean hasCycle() {

        Set<Node> visited = new HashSet<>();
        Set<Node> visiting = new HashSet<>();
        boolean result = false;
        for (var node : nodes.values())
            if (hasCycle(node, visited, visiting))
                return true;
        return false;
    }

    private boolean hasCycle(Node start, Set<Node> visited, Set<Node> visiting) {
        if (start == null)
            return false;

        visiting.add(start);
        for (var neighbor : adjacencyList.get(start)) {
            if (visited.contains(start))
                continue;

            if (visiting.contains(neighbor))
                return true;

            if (hasCycle(neighbor, visited, visiting))
                return true;
        }

        visiting.remove(start);
        visited.add(start);

        return false;
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public static void main(String[] args) {
        var test = new Graph();
        test.addNode("a");
        test.addNode("b");
        test.addNode("c");
        test.addNode("d");
        test.addNode("e");
        // test.addEdge("a", "b");
        // test.addEdge("b", "e");
        // test.addEdge("a", "e");
        // test.addEdge("c", "a");
        // test.addEdge("c", "b");
        // test.addEdge("c", "d");
        // test.addEdge("d", "e");
        test.addEdge("a", "b");
        test.addEdge("a", "c");
        test.addEdge("b", "d");
        test.addEdge("c", "d");
        test.addEdge("d", "a");

        test.print();
        // test.traverseDepthFirstRec("c");
        // test.traverseDepthFirstIter("c");
        // test.traverseBreathFirstIter("c");
        // var list = test.topologicalSort();
        var result = test.hasCycle();
        System.out.println(result);
    }
}