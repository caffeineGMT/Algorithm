import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        nodes.remove(node);
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
        test.addEdge("a", "b");
        test.addEdge("b", "c");
        test.addEdge("b", "d");
        // test.removeNode("a");
        test.removeEdge("b", "d");
        test.print();
    }
}